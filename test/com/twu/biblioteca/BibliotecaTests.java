package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import sun.swing.BakedArrayList;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by mcorrales on 7/23/15.
 */
public class BibliotecaTests {

    private ArrayList<Book> books;
    private Biblioteca biblioteca;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<Book>();
        biblioteca = new Biblioteca(books);
    }

    @Test
    public void testShouldHaveAListOfBooks() throws Exception {
        Book aBook = new Book("", "", "2013");
        books.add(aBook);

        ArrayList<Book> bibliotecaBooks = biblioteca.getBookList();

        assertArrayEquals("No list of books available", books.toArray(), bibliotecaBooks.toArray());
    }

    @Test
    public void testShouldAllowToCheckoutBook() throws Exception {
        Book aBook = new Book("Harry Potter", "JK Rowling", "2013");
        Book anotherBook = new Book("Harry Potter 2", "JK Rowling", "2013");
        books.add(aBook);
        books.add(anotherBook);

        biblioteca.checkoutBook("Harry Potter");
        ArrayList<Book> bookList = biblioteca.getBookList();

        assertEquals(1, bookList.size());
    }

    @Test
    public void testReturnsCheckedOutBook() {
        Book aBook = new Book("Harry Potter", "JK Rowling", "2013");
        Book anotherBook = new Book("Harry Potter 2", "JK Rowling", "2013");
        books.add(aBook);
        books.add(anotherBook);

        Book actual = biblioteca.checkoutBook("Harry Potter 2");

        assertEquals("Harry Potter 2", actual.getBookTitle());
    }

    @Test
    public void testRightBookWasCheckedOut() {
        Book harry1 = new Book("Harry Potter 1", "JK Rowling", "2013");
        Book harry2 = new Book("Harry Potter 2", "JK Rowling", "2013");
        Book harry3 = new Book("Harry Potter 3", "JK Rowling", "2013");
        books.add(harry1);
        books.add(harry2);
        books.add(harry3);
        ArrayList<Book> expectedBooks = new ArrayList<Book>();
        expectedBooks.add(harry1);
        expectedBooks.add(harry3);

        biblioteca.checkoutBook("Harry Potter 2");

        ArrayList<Book> actualBooks = biblioteca.getBookList();

        assertArrayEquals(expectedBooks.toArray(), actualBooks.toArray());
    }
}
