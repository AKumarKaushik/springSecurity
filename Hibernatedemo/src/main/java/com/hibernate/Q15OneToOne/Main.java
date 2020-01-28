package com.hibernate.Q15OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Author author = new Author();
        author.setFname("first name");
        author.setLname("last name");
        author.setAge(20);
        author.setId(1);
        author.setDob(new Date());
        Book book = new Book();
        book.setBookname("RS");
        author.setBook(book);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(author);
        session.save(book);
        tx.commit();
        session.close();
    }
}
