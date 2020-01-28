package com.hibernate;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.*;

@Entity
public class Author {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)   Q9
//    @GeneratedValue(strategy = GenerationType.TABLE)      Q9
    private int id;

    @Column(name = "first_name")   //Q6
    private String firstName;

   // @Transient                    //Q7
    @Column(name = "last_name")   //Q6
    private String lastName;

    private int age;

    @Temporal(TemporalType.DATE)   //Q8
    private Date dob;   //Q3


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Embedded
    Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @ElementCollection
    private List<String> subjects;

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

}
