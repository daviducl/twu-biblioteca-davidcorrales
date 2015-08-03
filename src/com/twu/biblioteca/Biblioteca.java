package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by mcorrales on 7/23/15.
 */
public class Biblioteca {

    private MockDatabase mockDatabase;
    public Movie[] availableMovies;

    public Biblioteca(MockDatabase mockDatabase) {
        this.mockDatabase = mockDatabase;
    }

    public ArrayList<Book> getAvailableBooks() {
        return this.mockDatabase.getAvailableBooks();
    }

    public Book checkoutBook(String bookTitle) {
        Book book = mockDatabase.findAndRemove(bookTitle);
        if (book == null)
            System.out.print("That book is not available");
        else
            System.out.print("Thank you! Enjoy the book");
        return book;
    }

    public void checkInMovie(String s) {
        
    }

    public void checkOutMovie(String s) {
    }

    public void returnBook(String bookTitle) {
        Book book = mockDatabase.findAndReturn(bookTitle);
        if (book == null)
            System.out.print("This is not a valid book to return");
        else
            System.out.print("Thank you for returning the book");
    }
}
