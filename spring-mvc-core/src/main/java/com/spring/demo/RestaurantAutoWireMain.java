package com.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RestaurantAutoWireMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-config2.xml");
        Restaurant restaurant = applicationContext.getBean(Restaurant.class);
        restaurant.getHotDrink().prepareDrink();
    }
}
