package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by mcorrales on 8/2/15.
 */
public class MockDatabase {
    private ArrayList<Book> allBooks = new ArrayList<Book>();
    private ArrayList<Book> availableBooks = new ArrayList<Book>();

    public MockDatabase() {
        Book infernoBook = new Book("Inferno", "Dan Brown", "2013");
        Book vinciBook = new Book("The Da Vinci Code", "Dan Brown", "2013");
        allBooks.add(infernoBook);
        allBooks.add(vinciBook);
        availableBooks.add(infernoBook);
        availableBooks.add(vinciBook);
    }
    public Book findAndRemove(String bookTitle) {
        Book book = findAvailableBook(bookTitle);
        availableBooks.remove(book);
        return book;
    }

    private Book findAvailableBook(String bookTitle) {
        for (Book book : this.availableBooks) {
            if (book.getBookTitle().equals(bookTitle)) {
                return book;
            }
        }
        return null;
    }

    private Book findAllBooks(String bookTitle) {
        for (Book book : this.allBooks) {
            if (book.getBookTitle().equals(bookTitle)) {
                return book;
            }
        }
        return null;
    }

    public void addBook(Book aBook) {
        this.allBooks.add(aBook);
        this.availableBooks.add(aBook);
    }

    public ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public String printBookList() {
        String bookList = "These are our books\n";
        for (Book book : allBooks) {
            bookList += book.toString();
        }
        return bookList;
    }

    public String printAvailableBooks() {
        String bookList = "These are our books\n";
        for (Book book : availableBooks) {
            bookList += book.toString();
        }
        return bookList;
    }

    public Book findAndReturn(String bookTitle) {
        Book book = findAllBooks(bookTitle);
        Book nullBook = findAvailableBook(bookTitle);
        if (book != null && nullBook == null)
            availableBooks.add(book);
        else
            return null;
        return book;
    }

    public ArrayList<Book> getAvailableBooks() {
        return availableBooks;
    }
}
