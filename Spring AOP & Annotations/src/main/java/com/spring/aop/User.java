package com.spring.aop;

public class User {
    String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void display(){
        System.out.println(name);
    }
    public User(){

    }
    public void  Mymethod() throws Exception{
        throw new Exception("Generic Errror ");
    }

    public void MethodParameter(int a){
        System.out.println("Method With Parameter");
    }

    Integer getInteger(Integer a){
        return 5;
    }
}
