package com.reap.project.reap.controller;

import com.reap.project.reap.dto.AdminDTO;
import com.reap.project.reap.dto.UserDTO;
import com.reap.project.reap.model.User;
import com.reap.project.reap.model.UserRecognize;
import com.reap.project.reap.repository.UserRepository;
import com.reap.project.reap.service.MailService;
import com.reap.project.reap.service.RoleService;
import com.reap.project.reap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MailService mailService;

    @RequestMapping(value = {"/","/login"},method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/login");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView fetchUserFromDatabase(User user, HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            if(userExists.getActive()>0){
                String userExistsPassword = userExists.getPassword();
                if (!userExistsPassword.isEmpty() && userExistsPassword.equals(user.getPassword())) {
                    httpSession.setAttribute("loggedInUser",userExists);
                    modelAndView.addObject("loggedInUser",userExists);
                    modelAndView = new ModelAndView("redirect:/dashboard");
                }else{
                    modelAndView.addObject("msg","Password Don't Match");
                    modelAndView.setViewName("/user/login");
                }
            }else{
                modelAndView.addObject("msg","User is not Active");
                modelAndView.setViewName("/user/login");
            }
        }else{
            modelAndView.addObject("msg","Email doesn't Exist");
            modelAndView.setViewName("/user/login");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView userLogout(HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView();
        httpSession.invalidate();
        modelAndView.setViewName("/user/login");
        return modelAndView;
    }


    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("/user/signup");
        return modelAndView;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView createUser(@Valid User user, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        User userExits = userService.findUserByEmail(user.getEmail());

        if(userExits!=null){
            bindingResult.rejectValue("email","error.user","This email already Exists");
        }

        if(bindingResult.hasErrors()){
            modelAndView.setViewName("/user/signup");
        }else{
               userService.saveUser(user);
               modelAndView.addObject("msg","Successfully Register");
               modelAndView.addObject("user",new User());
               modelAndView.setViewName("/user/signup");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/adminPanel" , method = RequestMethod.GET)
    public String AdminPanel(Model model){
        List<User> userList = userService.findAll();
        System.out.println("UserList Size "+userList.size());
        model.addAttribute("UserDTO",UserDTO.createDTO(userList));
        return "/user/adminPanel";
    }

    @RequestMapping(value = "/adminPanel", method = RequestMethod.POST)
    public ModelAndView updateUserByAdmin(AdminDTO adminDTO){
        userService.updateUser(adminDTO);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user/adminPanel");
        return modelAndView;
    }


    @RequestMapping(value = "/adminPanel/{userId}")
    public String deleteUser(@PathVariable int userId, RedirectAttributes redirectAttributes){
        User user = userService.findByID(userId);
        userService.delete(user);
        redirectAttributes.addFlashAttribute("message","User Deleted");
        return "redirect:/adminPanel";
    }

    @RequestMapping(value = {"/forgotPassword"},method = RequestMethod.GET)
    public ModelAndView forgotPassword(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/forgotPassword");
        return modelAndView;
    }

    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    public ModelAndView sendMail(User user){
        mailService.sendMail(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message","Password has been sent to "+user.getEmail());
        modelAndView.setViewName("/user/forgotPassword");
        return modelAndView;
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashboard(User loggedInUser){

        ModelAndView modelAndView = new ModelAndView();
        List<UserRecognize> userRecognizeList = userService.findRecognizeList();
        modelAndView.addObject("recognizeList",userRecognizeList);
        modelAndView.setViewName("/user/Dashboard");
        return modelAndView;
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.POST)
    public ModelAndView fetchRecognizeData(HttpSession httpSession, UserRecognize userRecognize, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        if(!bindingResult.hasErrors()){
            User loggedInUser = (User) httpSession.getAttribute("loggedInUser");
            boolean flag = userService.updateBadges(loggedInUser,userRecognize);
            List<UserRecognize> userRecognizeList = userService.findRecognizeList();
            modelAndView.addObject("recognizeList",userRecognizeList);
            if(flag){
                modelAndView.addObject("msg","Newers Recognized");
            }else{
                modelAndView.addObject("Errormsg","Insufficients Badges");
            }
            modelAndView.setViewName("/user/Dashboard");
        }else{
            modelAndView.addObject("msg","Invalid entry");
            modelAndView.setViewName("/user/Dashboard");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/allBadges", method = RequestMethod.GET)
    public ModelAndView showAllBadges(UserRecognize userRecognize, HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView();
        User loggedInUser = (User) httpSession.getAttribute("loggedInUser");
        List<UserRecognize> userRecognizeList = userService.findUserRecognizeforAllBadges(loggedInUser.getEmail(),loggedInUser.getId());
        modelAndView.addObject("recognizeList",userRecognizeList);
        modelAndView.setViewName("/user/allBadges");
        return modelAndView;
    }

    @RequestMapping(value = "/sharedBadges", method = RequestMethod.GET)
    public ModelAndView showSharedBadges(UserRecognize userRecognize, HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView();
        User loggedInUser = (User) httpSession.getAttribute("loggedInUser");
        List<UserRecognize> userRecognizeList = userService.findUserRecognizeForSharedBadges(loggedInUser.getId());
        modelAndView.addObject("recognizeList",userRecognizeList);
        modelAndView.setViewName("/user/sharedBadges");
        return modelAndView;
    }

    @RequestMapping(value = "/receivedBadges",method = RequestMethod.GET)
    public ModelAndView showreceivedBadges(UserRecognize userRecognize, HttpSession httpSession){
        ModelAndView modelAndView = new ModelAndView();
        User loggedInUser = (User) httpSession.getAttribute("loggedInUser");
        List<UserRecognize> userRecognizeList = userService.findUserRecognizeforReceivedBadges(loggedInUser.getEmail());
        modelAndView.addObject("recognizeList",userRecognizeList);
        modelAndView.setViewName("/user/receivedBadges");
        return modelAndView;
    }
}