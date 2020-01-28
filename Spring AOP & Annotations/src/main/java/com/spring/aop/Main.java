package com.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Aop.xml");
        User user = applicationContext.getBean(User.class);
        user.display();
 //       user.Mymethod();
        user.MethodParameter(5);
        user.getInteger(10);
    }
}
