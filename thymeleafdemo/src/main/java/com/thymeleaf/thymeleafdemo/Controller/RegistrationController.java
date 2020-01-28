package com.thymeleaf.thymeleafdemo.Controller;

import com.thymeleaf.thymeleafdemo.registrationForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RegistrationController {

    @RequestMapping(value="/registration",method = RequestMethod.GET)
    public String getRegistation(){
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute(name = "registrationForm") registrationForm registrationForm, Model model){
            String username = registrationForm.getUsername();
            String email = registrationForm.getEmail();
            String password = registrationForm.getPassword();
            if("admin".equals(username) && "admin".equals(password)) {
                return "Home";
            }else if(!username.isEmpty()){
                return "User";
            }
            model.addAttribute("invalidCredentials",true);
            return "registration";
    }

}