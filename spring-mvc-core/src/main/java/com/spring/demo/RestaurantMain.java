package com.spring.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RestaurantMain {
    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-config.xml");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-config3.xml");
        Restaurant restaurant = applicationContext.getBean(Restaurant.class);
        restaurant.getHotDrink().prepareDrink();
//        System.out.println(applicationContext.isPrototype("teaRestaurant"));
    }
}
