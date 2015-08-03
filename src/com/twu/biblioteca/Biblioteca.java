package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by mcorrales on 7/23/15.
 */
public class Biblioteca {

    private MockDatabase mockDatabase;

    public Biblioteca(MockDatabase mockDatabase) {
        this.mockDatabase = mockDatabase;
    }

    public ArrayList<Book> getAvailableBooks() {
        return this.mockDatabase.getAvailableBooks();
    }

    public Book checkoutBook(String bookTitle) {
        Book book = mockDatabase.findAndRemoveBook(bookTitle);
        if (book == null)
            System.out.print("That book is not available");
        else
            System.out.print("Thank you! Enjoy the book");
        return book;
    }

    public Movie checkoutMovie(String movieTitle) {
        Movie movie = mockDatabase.findAndRemoveMovie(movieTitle);
        if (movie == null)
            System.out.print("That movie is not available");
        else
            System.out.print("Thank you! Enjoy the movie");
        return movie;
    }

    public void returnBook(String bookTitle) {
        Book book = mockDatabase.findAndReturnBook(bookTitle);
        if (book == null)
            System.out.print("This is not a valid book to return");
        else
            System.out.print("Thank you for returning the book");
    }

    public ArrayList<Movie> getAvailableMovies() {
        return this.mockDatabase.getAvailableMovies();
    }
}
