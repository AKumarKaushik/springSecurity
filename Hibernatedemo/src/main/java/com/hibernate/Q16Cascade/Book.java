package com.hibernate.Q16Cascade;

import javax.persistence.*;

@Entity
public class Book {
    private String bookName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Author author;
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
