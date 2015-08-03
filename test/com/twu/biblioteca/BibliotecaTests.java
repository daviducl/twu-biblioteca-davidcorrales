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
    public void testShouldHaveAListOfBooks() throws Exception {
        Book aBook = new Book("", "", "2013");
        mockDatabase.addBook(aBook);

        ArrayList<Book> bibliotecaBooks = biblioteca.getBookList();

        assertArrayEquals("No book list available", mockDatabase.getBooks().toArray(), bibliotecaBooks.toArray());
    }

    @Test
    public void testShouldAllowToCheckoutBook() throws Exception {
        Book aBook = new Book("Harry Potter", "JK Rowling", "2013");
        Book anotherBook = new Book("Harry Potter 2", "JK Rowling", "2013");
        mockDatabase.addBook(aBook);
        mockDatabase.addBook(anotherBook);

        biblioteca.checkoutBook("Harry Potter");
        ArrayList<Book> bookList = biblioteca.getBookList();

        assertEquals(3, bookList.size());
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

        ArrayList<Book> actualBooks = biblioteca.getBookList();

        assertTrue(!actualBooks.contains(harry));
    }
}
