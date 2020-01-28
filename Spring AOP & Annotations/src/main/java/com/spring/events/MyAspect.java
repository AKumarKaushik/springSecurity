package com.spring.events;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
    @Before("execution(public void display())")
    void beforeAdvice(){         // envoke display an advice before any method that has the signature public void display()
        System.out.println("Before Advice Is Running with public void display");
    }

    @Before("execution( * get*())")
    void beforeAdvice2() {      // envoke display an advice before any getter method
        System.out.println("Before advice is Running with getter method");
    }
    @Before("execution( * com.spring.events.Dummy.*())")
    void beforeAdvice3() {      // envoke an advice before all the methods inside Dummy class which does not take any argument.
        System.out.println("Before advice is Running with package no argument");
    }

    @Before("execution(* *())")
    void beforeAdvice4() {      // envoke an advice before any method which takes no argument
        System.out.println("Before advice with No argument");
    }

    @Before("execution(* *(..))")
    void beforeAdvice5() {      // Will envoke an advice before any method
        System.out.println("Before advice before any method");
    }
}
