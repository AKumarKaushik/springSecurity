package com.spring.events;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspectAdvice {
    @Before("execution(void display())")
    void beforeAdvice() {
        System.out.println("Running before advice display");
    }

    @AfterReturning(pointcut = "execution(Integer getInteger())", returning = "returnValue")
    void afterReturningAdvice(Integer returnValue) {
        System.out.println("Running AfterReturning " + returnValue);
    }

    @AfterThrowing(pointcut = "execution(void throwException())", throwing = "ex")
    void afterReturningAdvice(Exception ex) {
        System.out.println("Running AfterThrowing " + ex);
    }

    @After("execution(public void display2())")
    void afterAdvice(){
        System.out.println("Running after advice display 2");
    }

    @Around("execution(public void display3())")
    void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Around before");
        proceedingJoinPoint.proceed();
        System.out.println("Around after");
    }
}
