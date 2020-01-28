package com.hibernate.Q17ManyToMany;

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
        book.setBookName("java");
        Book book1 = new Book();
        book1.setBookName("hibernate");
        session.save(book);
        session.save(book1);

        List<Book> bookList = new ArrayList();
        bookList.add(book);
        bookList.add(book1);

        Author author = new Author();
        author.setAge(23);
        author.setId(2);
        author.setFirstName("first");
        author.setLastName("name");
        author.setBook(bookList);
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
    }
}
