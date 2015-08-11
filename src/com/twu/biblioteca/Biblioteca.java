package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by mcorrales on 7/23/15.
 */
public class Biblioteca {

    private MockDatabase mockDatabase;
    private MockUsers mockUsers;
    private boolean isAuthenticated = false;
    private User currentUser;

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

    public ArrayList<User> getUserList() {
        return mockUsers.getUserList();
    }

    public Book checkoutBook(String bookTitle) {
        return mockDatabase.findAndRemoveBook(bookTitle);
    }

    public Movie checkoutMovie(String movieTitle) {
        return mockDatabase.findAndRemoveMovie(movieTitle);
    }

    public Book returnBook(String bookTitle) {
        return mockDatabase.findAndReturnBook(bookTitle);
    }

    public User authenticateUser(String userId, String password) {
        User user = mockUsers.authenticateUser(userId, password);
        if (user != null) {
            isAuthenticated = true;
        }
        currentUser = user;
        return currentUser;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public User getCurrentUser(){
        return currentUser;
    }
}
