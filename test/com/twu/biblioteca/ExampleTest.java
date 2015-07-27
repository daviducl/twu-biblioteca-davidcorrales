package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class ExampleTest {

    private ItemLists theLists;
    private BibliotecaApp biblioteca;
    
    @Before
    public void setUp() {
        theLists = new ItemLists();
        biblioteca = new BibliotecaApp();
    }

    @Test
    public void mainGreetingDisplays() {
        assertEquals("Menu not displayed properly", "Welcome to the Biblioteca\n", biblioteca.displayMenuGreeting());
    }

    @Test
    public void bookListDisplays() {
        ListBooksItem listBooksItem = new ListBooksItem("", "");
        String test = "These are our books:\n";
        for (Book theBook : theLists.allBooks) {
            test += theBook.toString();
        }

        assertEquals("Books not displaying properly", test, listBooksItem.displayBookList(theLists));
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
        ArrayList<AppMenuItem> theMenu = new ArrayList<AppMenuItem>();

        AppMenuItem theItem = new AppMenuItem("1", "");
        theMenu.add(theItem);

        assertEquals("Invalid selection not working", "Select a valid option!\n", biblioteca.mainMenuSelector(theMenu, 2, theLists));
    }

    @Test
    public void bookCheckoutSuccessful() {
        Book vinciBook = new Book("Inferno", "Dan Brown", "2013");

        theLists.checkOutBook("Inferno");

        assertFalse("Book Checkout Unsuccessful", theLists.availableBooks.contains(vinciBook));
    }

    @Test
    public void bookReturnSuccessful() {
        Book vinciBook = new Book("The Da Vinci Code", "Dan Brown", "2003");

        theLists.checkInMovie("The Da Vinci Code");

        assertFalse("Book Return Unsuccessful", theLists.checkedOutBooks.contains(vinciBook));
    }

    @Test
    public void movieListDisplays() {
        ListMoviesItem listMoviesItem = new ListMoviesItem("", "");
        String test = "These are our movies:\n";
        for (Movie theMovie : theLists.allMovies) {
            test += theMovie.toString();
        }

        assertEquals("Movies not displaying properly", test, listMoviesItem.displayMovieList(theLists));
    }

    @Test
    public void movieCheckoutSuccessful() {
        Movie vinciBook = new Movie("Inferno", "Dan Brown", "2013", "4");
        theLists.availableMovies.add(vinciBook);

        theLists.checkOutMovie("Inferno");

        assertFalse("Book Checkout Unsuccessful", theLists.availableMovies.contains(vinciBook));
    }
}
