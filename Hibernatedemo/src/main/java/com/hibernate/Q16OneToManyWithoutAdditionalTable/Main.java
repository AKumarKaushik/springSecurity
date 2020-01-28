package com.hibernate.Q16OneToManyWithoutAdditionalTable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Author author = new Author();
        author.setFname("name");
        author.setLname("name");
        author.setAge(25);
        author.setId(1);
        author.setDob(new Date());
        Book book = new Book();
        book.setBookname("zz");
        book.setAuthor(author);
        Book book1 = new Book();
        book1.setBookname("ii");
        book1.setAuthor(author);
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
