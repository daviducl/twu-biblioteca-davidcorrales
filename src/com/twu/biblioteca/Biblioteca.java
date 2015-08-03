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

    public ArrayList<Book> getBookList() {
        return this.mockDatabase.getBooks();
    }

    public Book checkoutBook(String bookTitle) {
        Book book = mockDatabase.findAndRemove(bookTitle);
        return book;
    }

    public void checkInMovie(String s) {
        
    }

    public void checkOutMovie(String s) {
    }
}
