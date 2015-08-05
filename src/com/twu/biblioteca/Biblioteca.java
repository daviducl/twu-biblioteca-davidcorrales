package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by mcorrales on 7/23/15.
 */
public class Biblioteca {

    private MockDatabase mockDatabase;
    private MockUsers mockUsers;

    public Biblioteca(MockDatabase mockDatabase) {
        this.mockDatabase = mockDatabase;
        this.mockUsers = new MockUsers();
    }

    public ArrayList<Book> getAvailableBooks() {
        return this.mockDatabase.getAvailableBooks();
    }

    public ArrayList<Movie> getAvailableMovies() {
        return this.mockDatabase.getAvailableMovies();
    }

    public Book checkoutBook(String bookTitle) {
        Book book = mockDatabase.findAndRemoveBook(bookTitle);
        return book;
    }

    public Movie checkoutMovie(String movieTitle) {
        Movie movie = mockDatabase.findAndRemoveMovie(movieTitle);
        return movie;
    }

    public Book returnBook(String bookTitle) {
        Book book = mockDatabase.findAndReturnBook(bookTitle);
        return book;
    }

    public ArrayList<User> getUserList() {
        return mockUsers.getUserList();
    }

    public User authenticateUser(String userId, String password) {
        return mockUsers.authenticateUser(userId, password);
    }
}
