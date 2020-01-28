package com.spring.events;

public class DummyAdvice {
    public void display(){
        System.out.println("Into Dummy Advice ");
    }

    public Integer getInteger(){
        return 5;
    }

    public void  Mymethod() throws Exception{
        throw new Exception("Generic Errror ");
    }

    public void display2(){
        System.out.println("Into Display");
    }

    public void display3(){
        System.out.println("Testing Around ");
    }
}
