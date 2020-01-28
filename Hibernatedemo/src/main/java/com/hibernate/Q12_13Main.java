package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Q12_13Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Author author = new Author();
        author.setFirstName("First Author");
        author.setLastName("First Name");
        author.setId(1);
        author.setAge(20);

        List<String> list = new ArrayList();
        list.add("Subject One");
        list.add("Subject Two");
        list.add("Subject Three");

        author.setSubjects(list);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(author);
        tx.commit();
        session.close();

    }
}
