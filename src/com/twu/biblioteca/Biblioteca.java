package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by mcorrales on 7/23/15.
 */
public class Biblioteca {

    private ArrayList<Book> books;

    public Biblioteca(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBookList() {
        return this.books;
    }

    public Book checkoutBook(String bookTitle) {
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
}
