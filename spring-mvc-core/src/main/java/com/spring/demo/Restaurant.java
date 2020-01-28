package com.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;

@Controller
public class Restaurant {
    private HotDrink hotDrink;

    public HotDrink getHotDrink() {
        System.out.println("Inside Getter Of Restaurant");
        return hotDrink;
    }

//    @Required
    @Autowired
    @Qualifier("tea")
    public void setHotDrink(HotDrink hotDrink) {
        System.out.println("Inside Setter Of Restaurant");
        this.hotDrink = hotDrink;
    }

//    @Autowired
    /*public Restaurant(HotDrink hotDrink123) {
        System.out.println("Inside Constructor Of Restaurant");
        this.hotDrink = hotDrink123;
    }*/
}
