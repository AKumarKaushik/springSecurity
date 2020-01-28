package com.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
//import org.apache.log4j.Logger;

@Aspect
@EnableAspectJAutoProxy
public class MyLogger {
//    private final static Logger logger = Logger.getLogger(MyLogger.class);

    // Q1 + Q2
    @Before("execution(public void display())")
    public void log() {
        System.out.println("Before advice running");
    }
    // Q1 + Q2 + Q4
    @After("execution(public void display())")
    public void log2() {
//        logger.info(point.getSignature().getName() + " called...");
        System.out.println("After advice running");
    }

    // Q3
    @AfterThrowing(pointcut = "execution(void throwException())", throwing = "ex")
    void afterReturningAdvice(Exception ex) {
        System.out.println("Running AfterThrowing " + ex);
    }

    // Q4
    @Before("within(com.spring.aop.Q1.*)")
    void before() {
        System.out.println("Running before advice from within");
    }

    // Q4
    @Before("this(com.spring.aop.User)")
    void beforeRun() {
        System.out.println("Running before advice from this");
    }

    // Q4
    @After("bean(User)")
    void AfterBean() {
        System.out.println("Running after advice of Bean");
    }

    // Q4
    @Before("args(Integer)")
    void beforeAdvice() {
        System.out.println("Running before advice args");
    }

    // Q5
    @Pointcut("execution(public void display())")
    public void displayPointCut() {
    }

    //Q5
    @After("displayPointCut()")
    public void runningAfterDisplayPointCut(){
        System.out.println("running After Display PointCut");
    }

    //Q6
    @Before("execution(Integer getInteger(Integer))")
    void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("------------------------------------");
        System.out.println("Running before advice in JoinPoint");
        System.out.println(joinPoint);
        System.out.println(joinPoint.getThis());
        System.out.println(joinPoint.getSignature());
        Object [] objects=joinPoint.getArgs();
        for (Object object:objects){
            System.out.println(object);
        }
        System.out.println("#######################################");
    }

}
