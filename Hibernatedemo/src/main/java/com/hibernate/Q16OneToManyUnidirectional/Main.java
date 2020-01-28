package com.hibernate.Q16OneToManyUnidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Author author = new Author();
        author.setFname("fname");
        author.setLname("lname");
        author.setAge(25);
        author.setId(1);
        Book book = new Book();
        book.setBookname("AB");
        Book book1 = new Book();
        book1.setBookname("XY");
        author.getBook().add(book);
        author.getBook().add(book1);
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(author);
        session.save(book);
        session.save(book1);
        tx.commit();
        session.close();
    }
}
