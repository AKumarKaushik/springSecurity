package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HibernateMain {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Author author = new Author();
        author.setFirstName("First Author");
        author.setLastName("First Name");
        author.setId(1);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(author);

        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
