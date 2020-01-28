package com.example.springSecurity.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Model model, Principal principal) {
        model.addAttribute("msg", "This is "+principal.getName());
        return "home";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/logout-success")
    public String logout() {
        return "logout";
    }
/*
    @RequestMapping("/user")
    public String user(Model model, Principal principal) {
        model.addAttribute("msg", "This is "+principal.getName());
        return "user";
    }*/

    @RequestMapping("/admin")
    public String admin(Model model, Principal principal) {
        model.addAttribute("msg", "This is "+principal.getName());
        return "admin";
    }

    @RequestMapping("/user")
    @ResponseBody
    public Principal user(Principal principal){
        return principal;
    }

}
