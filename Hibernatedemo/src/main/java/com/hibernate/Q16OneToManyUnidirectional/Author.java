package com.hibernate.Q16OneToManyUnidirectional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String fname;
    private String lname;
    private int age;
    private Date dob;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
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

    public Author(String fname, String lname, int age, Date dob) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.dob = dob;
    }

    public Author() {
    }

    @OneToMany
    @JoinTable(joinColumns = @JoinColumn(name="AUTHOR_ID")
            ,inverseJoinColumns = @JoinColumn(name = "Book_ID"))
    List<Book> book = new ArrayList<Book>();

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }
}

