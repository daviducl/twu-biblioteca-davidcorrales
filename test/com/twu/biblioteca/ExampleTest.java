package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class ExampleTest {

    @Test
    public void mainGreetingDisplays() {
        BibliotecaApp biblioteca = new BibliotecaApp();

        assertEquals("Menu not displayed properly", "Welcome to the Biblioteca\n", biblioteca.displayMenuGreeting());
    }

    @Test
    public void bookListDisplays() {
        ListBooksItem listBooksItem = new ListBooksItem("", "");
        BookLists theBookLists = new BookLists();
        String test = "These are our books:\n";
        for (Book theBook : theBookLists.allBooks) {
            test += theBook.toString();
        }

        assertEquals("Books not displaying properly", test, listBooksItem.displayBookList(theBookLists));
    }

    @Test
    public void bookDetailsDisplay() {
        Book book = new Book("Inferno", "Dan Brown", "2013");

        assertEquals("Book details not showing", "\"Inferno\" (2013) by Dan Brown\n", book.toString());
    }

    @Test
    public void menuItemDisplays() {
        AppMenuItem menuItem = new AppMenuItem("1", "List Books");

        assertEquals("Main Menu not displaying properly", "1. List Books", menuItem.toString());
    }

    @Test
    public void menuOptionSelectedIsInvalid() {
        BibliotecaApp biblioteca = new BibliotecaApp();
        ArrayList<AppMenuItem> theMenu = new ArrayList<AppMenuItem>();
        BookLists theBookLists = new BookLists();

        AppMenuItem theItem = new AppMenuItem("1", "");
        theMenu.add(theItem);

        assertEquals("Invalid selection not working", "Select a valid option!\n", biblioteca.menuSelector(theMenu, 2, theBookLists));
    }

    @Test
    public void bookCheckoutSuccessful() {
        BookLists theLists = new BookLists();
        Book vinciBook = new Book("Inferno", "Dan Brown", "2013");

        theLists.checkOut("Inferno");

        assertFalse("Book Checkout Unsuccessful", theLists.availableBooks.contains(vinciBook));
    }

    @Test
    public void bookReturnSuccessful() {
        BookLists theLists = new BookLists();
        Book vinciBook = new Book("The Da Vinci Code", "Dan Brown", "2003");

        theLists.checkIn("The Da Vinci Code");

        assertFalse("Book Return Unsuccessful", theLists.checkedOutBooks.contains(vinciBook));
    }

    @Test
    public void movieListDisplays() {
        ListMoviesItem listMoviesItem = new ListMoviesItem("", "");
        MovieLists theMovieLists = new MovieLists();
        String test = "These are our movies:\n";
        for (Movie theMovie : theMovieLists.allMovies) {
            test += theMovie.toString();
        }

        assertEquals("Movies not displaying properly", test, listMoviesItem.displayMovieList(theMovieLists));
    }
}
