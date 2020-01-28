package java2_Assgnmnt;
import java.io.*;

interface library {
    void addBook(String book, int number);

    void showAllBooks();
}

class Book implements library {

    int count ;
    String name = " ";

    @Override
    public void addBook(String book, int number) {
        count = number;
        name = book;
    }

    @Override
    public void showAllBooks() {
        System.out.println("name of the book is :"+ name+"  "+ "and the count is :"+ count);
    }
}

public class Q1_LibraryManagement {
    public static void main(String[] args) {
        Book b1 = new Book();
        b1.addBook("Ramayana",2);
        b1.showAllBooks();

        Book b2 = new Book();
        b1.addBook("Geeta", 3);
        b1.showAllBooks();

    }
}
