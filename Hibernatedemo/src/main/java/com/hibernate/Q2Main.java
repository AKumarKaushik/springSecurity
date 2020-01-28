package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Q2Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Author author = new Author();
        author.setFirstName("First Author");
        author.setLastName("First Name");
        author.setId(1);
        author.setAge(20);
        author.setDob(new Date());

        // Create
       /* Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(author);
        tx.commit();
        session.close();*/

        //Read
      /*  Session session1 = sessionFactory.openSession();
        Transaction tx1 = session1.beginTransaction();
        Author author1 = session1.get(Author.class,1);
        session1.save(author1);
        tx1.commit();
        session1.close();
        System.out.println(author1.getAge());*/

        //Update
      /*  Session session2 = sessionFactory.openSession();
        Transaction tx2 = session2.beginTransaction();
        Author author2 = session2.get(Author.class,1);
        author2.setFirstName("Name");
        session2.update(author2);
        tx2.commit();
        session2.close();*/

        //Delete
       /* Session session3 = sessionFactory.openSession();
        Transaction tx3 = session3.beginTransaction();
        Author author3 = session3.get(Author.class,1);
        session3.delete(author3);
        tx3.commit();
        session3.close();*/
    }
}
