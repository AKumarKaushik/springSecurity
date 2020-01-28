package com.spring.events;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DummyAdviceMain {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext cfx = new ClassPathXmlApplicationContext("Advice-config.xml");
        DummyAdvice da = cfx.getBean(DummyAdvice.class);
        da.display();
        int n = da.getInteger();
//        da.Mymethod();
        da.display2();
        da.display3();
//        System.out.println("###### "+n);
    }
}
