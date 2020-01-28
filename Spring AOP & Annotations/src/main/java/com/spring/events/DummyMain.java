package com.spring.events;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DummyMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext cfx = new ClassPathXmlApplicationContext("Spring-Config.xml");
        Dummy dummy = cfx.getBean(Dummy.class);
        dummy.display();
        String name = dummy.getName();
        System.out.println(name);
        cfx.refresh();
        cfx.start();
        cfx.stop();
        cfx.close();
    }
}