package com.thymeleaf.thymeleafdemo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("/sayHello")
    public String sayHello(){
        return "hello";
    }

    @GetMapping("/main")
    public String getMain(){
        return "Main";
    }

    @GetMapping("/table")
    public String getTable(){
        return "table";
    }


    @GetMapping("/enums")
    public String getEnums(){
        return "enum";
    }
}
