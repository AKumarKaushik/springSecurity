package com.hibernate.Q16Cascade;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Book book = new Book();
        book.setBookName("java ee");
        Book book1 = new Book();
        book1.setBookName("hibernate");


        List<Book> bookList = new ArrayList();
        bookList.add(book);
        bookList.add(book1);

        Author author = new Author();
        author.setAge(23);
        author.setId(2);
        author.setFirstName("Akash");
        author.setLastName("Kaushik");
        author.setBook16(bookList);
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
    }
}
