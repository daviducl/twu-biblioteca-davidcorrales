package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by mcorrales on 7/23/15.
 */
public class BibliotecaTests {

    private MockDatabase mockDatabase;
    private MockUsers mockUsers;
    private Biblioteca biblioteca;

    @Before
    public void setUp() throws Exception {
        mockDatabase = new MockDatabase();
        biblioteca = new Biblioteca(mockDatabase);
        mockUsers = new MockUsers();
    }

    @Test
    public void testShouldHaveAListOfBooks() {
        ArrayList<Book> bibliotecaBooks = biblioteca.getAvailableBooks();

        assertArrayEquals("No book list available", mockDatabase.getAllBooks().toArray(), bibliotecaBooks.toArray());
    }

    @Test
    public void testShouldAllowToCheckoutBook() {
        Book aBook = new Book("Harry Potter", "JK Rowling", "2013");
        mockDatabase.addBook(aBook);

        biblioteca.checkoutBook("Harry Potter");
        ArrayList<Book> bookList = biblioteca.getAvailableBooks();

        assertEquals(2, bookList.size());
    }

    @Test
    public void testReturnsCheckedOutBook() {
        Book aBook = new Book("Harry Potter", "JK Rowling", "2013");
        Book anotherBook = new Book("Harry Potter 2", "JK Rowling", "2013");
        mockDatabase.addBook(aBook);
        mockDatabase.addBook(anotherBook);

        Book actual = biblioteca.checkoutBook("Harry Potter 2");

        assertEquals("Harry Potter 2", actual.getBookTitle());
    }

    @Test
    public void testRightBookWasCheckedOut() {
        Book harry = new Book("Harry Potter 2", "JK Rowling", "2013");
        mockDatabase.addBook(harry);

        biblioteca.checkoutBook("Harry Potter 2");

        ArrayList<Book> actualBooks = biblioteca.getAvailableBooks();

        assertTrue(!actualBooks.contains(harry));
    }

    @Test
    public void testShouldAllowToReturnBook() {
        biblioteca.checkoutBook("Inferno");
        biblioteca.returnBook("Inferno");

        ArrayList<Book> bookList = biblioteca.getAvailableBooks();

        assertEquals("Book Return not allowed", 2, bookList.size());
    }

    @Test
    public void testShouldHaveAListOfMovies() {
        Movie aMovie = new Movie("", "", "2013", "");
        mockDatabase.addMovie(aMovie);

        ArrayList<Movie> bibliotecaMovies = biblioteca.getAvailableMovies();

        assertArrayEquals("No book list available", mockDatabase.getAllMovies().toArray(), bibliotecaMovies.toArray());
    }

    @Test
    public void testShouldAllowToCheckoutMovie() {
        Movie aMovie = new Movie("Harry Potter", "JK Rowling", "2013", "5");
        mockDatabase.addMovie(aMovie);

        biblioteca.checkoutMovie("Harry Potter");
        ArrayList<Movie> movieList = biblioteca.getAvailableMovies();

        assertEquals(2, movieList.size());
    }

    @Test
    public void testRightMovieWasCheckedOut() {
        Movie harry = new Movie("Harry Potter 2", "JK Rowling", "2013", "5");
        mockDatabase.addMovie(harry);

        biblioteca.checkoutMovie("Harry Potter 2");

        ArrayList<Movie> actualMovies = biblioteca.getAvailableMovies();

        assertTrue("Wrong or no movie was checked out", !actualMovies.contains(harry));
    }

    @Test
    public void testShouldHaveAListOfUsers() {
        String expected = biblioteca.getUserList().get(0).toString();
        String actual = mockUsers.getUserList().get(0).toString();
        assertEquals("No user list available", expected, actual);
    }

    @Test
    public void testUserListShouldNotBeNull() {
        ArrayList<User> userList = biblioteca.getUserList();

        assertNotEquals("User list is null", null, userList);
    }

    @Test
    public void testShouldAuthenticateUsers() {
        String userId = "123-4567";
        String password = "password";

        assertNotNull("User is null", biblioteca.authenticateUser(userId, password));
    }
}
