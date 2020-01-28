package com.ttn.Q3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Q3.xml");
        Hibernate hibernate = applicationContext.getBean(Hibernate.class);
        hibernate.sessionFactoryDemo();
    }
}
