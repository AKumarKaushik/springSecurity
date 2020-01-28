package com.spring.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentCOMain {
    @RequestMapping(value = "/index2", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("form");
        return modelAndView;
    }

    @ModelAttribute
    public void addAttribute(Model model ){
        model.addAttribute("heading","This is spring mvc");
    }

    @RequestMapping("/test")
    ModelAndView test(){
        ModelAndView modelAndView = new ModelAndView("form");
        return modelAndView;
    }
  /*  @RequestMapping(value = "/submittform", method = RequestMethod.POST)
    @ResponseBody
    public String submitForm(@RequestParam("UserName") String username,
                             @RequestParam("LastName") String lastname) {
        StudentCO studentCO = new StudentCO();
        studentCO.setUserName(username);
        studentCO.setLastName(lastname);
        return "Username " + studentCO.getUserName() + " LastName " + studentCO.getLastName();
    }*/

   /* @RequestMapping(value = "/submittform", method = RequestMethod.POST)
    @ResponseBody
   public ModelAndView submitForm(@ModelAttribute("studentco") StudentCO studentco) {
        ModelAndView modelAndView = new ModelAndView("submittedData");
        return modelAndView;
    }*/
}



