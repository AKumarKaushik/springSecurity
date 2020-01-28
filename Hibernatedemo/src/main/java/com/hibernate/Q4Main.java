package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Q4Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Author author = new Author();
        author.setFirstName("First Author");
        author.setLastName("First Name");
        author.setId(1);
        author.setAge(20);
        author.setDob(new Date());

        Author author1 = new Author();
        author1.setFirstName("Second Author");
        author1.setLastName("Second Name");
        author1.setId(2);

        Author author2 = new Author();
        author2.setFirstName("Third Author");
        author2.setLastName("Third Name");
        author2.setId(3);

        Author author3 = new Author();
        author3.setFirstName("Fourth Author");
        author3.setLastName("Fourth Name");
        author3.setId(4);

        Author author4 = new Author();
        author4.setFirstName("Fifth Author");
        author4.setLastName("Fifth Name");
        author4.setId(5);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(author);
        session.save(author1);
        session.save(author2);
        session.save(author3);
        session.save(author4);
        tx.commit();
        session.close();

    }
}
