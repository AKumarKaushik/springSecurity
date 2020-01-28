package com.spring.events;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DatabaseMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring-Config.xml");
        Database database = applicationContext.getBean(Database.class);
        ((ClassPathXmlApplicationContext) applicationContext).refresh();
        ((ClassPathXmlApplicationContext) applicationContext).start();
        System.out.println(database);
        ((ClassPathXmlApplicationContext) applicationContext).stop();
    }
}
