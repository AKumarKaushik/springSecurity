package com.restwithSpring.RestWithSpring.Entity;

public class StudentName {

    private String firstName;
    private String lname;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public StudentName(String firstName, String lname) {
        this.firstName = firstName;
        this.lname = lname;
    }

    public StudentName() {
    }

    @Override
    public String toString() {
        return "StudentName{" +
                "firstName='" + firstName + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }
}
