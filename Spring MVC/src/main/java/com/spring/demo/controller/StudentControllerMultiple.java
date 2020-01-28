package com.spring.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

//@RequestMapping("/studentMultiple")
//@Controller
public class StudentControllerMultiple extends MultiActionController {
//    @RequestMapping("/dummy")
    public ModelAndView dummy(HttpServletRequest httpServletRequest,
                              HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("welcomeMsg","Welcome From Hello Controller");
        return modelAndView;
    }
//    @RequestMapping("/dummy2")
    public void dummy2(HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setContentType("text/html");
        httpServletResponse.getWriter().println("<b>HELLO World</b>");
    }
//    @ResponseBody
//    @RequestMapping("/demoAction")
    String demoAction() {
        return "HelloWorld";
    }

//    @ResponseBody
//    @RequestMapping("/index")
    public ModelAndView dummy3(HttpServletRequest httpServletRequest,
                              HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("welcomeMsg","Hello World");
        return modelAndView;
    }

//    @ResponseBody
//    @RequestMapping("/hello/{country}/{state}")
    public String hello(@PathVariable() Map<String,String> map){
        String country = map.get("country");
        String state = map.get("state");
        return "Country is "+country+" State is "+state;
    }


//
//    @RequestMapping("/form")
    ModelAndView form(){
        ModelAndView modelAndView=new ModelAndView("form");
        return modelAndView;
    }

//    @RequestMapping(value = "/submitForm")
//    @ResponseBody
    public String submitForm(@RequestParam("username") String username,
                      @RequestParam("age") String age,
                      @RequestParam("Email") String email) {
        return "Username " + username + " Age " + age + "Email" + email;
    }


}
