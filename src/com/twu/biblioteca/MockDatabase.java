package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by mcorrales on 8/2/15.
 */
public class MockDatabase {
    private ArrayList<Book> books = new ArrayList<Book>();

    public Book findAndRemove(String bookTitle) {
        Book book = findBook(bookTitle);
        books.remove(book);
        return book;
    }

    private Book findBook(String bookTitle) {
        for (Book book : this.books) {
            if (book.getBookTitle().equals(bookTitle)) {
                return book;
            }
        }
        return null;
    }

    public void addBook(Book aBook) {
        this.books.add(aBook);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public String printBookList() {
        String bookList = "";
        for (Book book : books) {
            bookList += book.toString();
        }
        return bookList;
    }
}
