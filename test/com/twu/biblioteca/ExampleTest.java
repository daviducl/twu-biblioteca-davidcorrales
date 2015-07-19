package com.twu.biblioteca;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ExampleTest {

    @Test
    public void menuGreetingDisplays() {
        BibliotecaApp biblioteca = new BibliotecaApp();

        assertEquals("Menu not displayed properly", "Welcome to the Biblioteca", biblioteca.displayMenuGreeting());
    }

    @Test
    public void bookListDisplays() {
        BibliotecaApp biblioteca = new BibliotecaApp();
        ArrayList<BookDetails> bookList = new ArrayList<BookDetails>();

        BookDetails book = new BookDetails("Inferno", "Dan Brown", "2013");
        bookList.add(book);

        assertNotNull("Books not displaying properly", biblioteca.displayBookList(bookList));
    }

    @Test
    public void bookDetailsDisplay() {
        BookDetails book = new BookDetails("Inferno", "Dan Brown", "2013");

        assertEquals("Book details not showing", "\"Inferno\" (2013) by Dan Brown\n", book.toString());
    }
}
