package com.restwithSpring.RestWithSpring.Entity;

public class StudentV2 {

    private StudentName name;

    public StudentName getName() {
        return name;
    }

    public void setName(StudentName name) {
        this.name = name;
    }

    public StudentV2(StudentName name) {
        this.name = name;
    }
}
