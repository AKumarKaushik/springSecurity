package com.example.SpringBoot.demoSpringBoot.Controller;

import com.example.SpringBoot.demoSpringBoot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerQ3 {

    @Autowired
    User user;

    @RequestMapping("/getUser")
    public User user(){
        user.setUsername("Akash");
        user.setPassword("Kaushik");
        return user;
    }
}
