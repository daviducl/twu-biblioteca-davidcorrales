package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by mcorrales on 7/23/15.
 */
public class BibliotecaTests {

    private MockDatabase mockDatabase;
    private Biblioteca biblioteca;

    @Before
    public void setUp() throws Exception {
        mockDatabase = new MockDatabase();
        biblioteca = new Biblioteca(mockDatabase);
    }

    @Test
    public void testShouldHaveAListOfBooks() {
        Book aBook = new Book("", "", "2013");
        mockDatabase.addBook(aBook);

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
    public void testShouldAllowToCheckoutMovie() {
        Movie aMovie = new Movie("Harry Potter", "JK Rowling", "2013", "5");
        mockDatabase.addMovie(aMovie);

        biblioteca.checkoutMovie("Harry Potter");
        ArrayList<Movie> movieList = biblioteca.getAvailableMovies();

        assertEquals(2, movieList.size());
    }
}
