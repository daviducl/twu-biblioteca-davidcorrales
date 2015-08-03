package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class AppUserInterfaceTests {

    private ItemLists theLists;
    private AppUserInterface appUserInterface;
    private MockDatabase mockDatabase;
    private Biblioteca biblioteca;

    @Before
    public void setUp() {
        theLists = new ItemLists();
        appUserInterface = new AppUserInterface();
        mockDatabase = new MockDatabase();
        biblioteca = new Biblioteca(mockDatabase);
    }

    @Test
    public void testMainGreetingDisplays() {
        assertEquals("Menu not displayed properly", "Welcome to the Biblioteca\n", appUserInterface.displayMenuGreeting());
    }

    @Test
    public void bookListDisplays() {
        String bookListOutput = mockDatabase.printBookList();

        assertEquals("Books not displaying properly", bookListOutput, appUserInterface.displayBookList(mockDatabase));
    }

    @Test
    public void bookDetailsDisplay() {
        Book book = new Book("Inferno", "Dan Brown", "2013");

        assertEquals("Book details not showing", "\"Inferno\" (2013) by Dan Brown\n", book.toString());
    }

    @Test
    public void menuItemDisplays() {
        AppMenu menu = new AppMenu();
        AppMenuItem menuItem = new AppMenuItem("1", "List Books");

        assertEquals("Main Menu not displaying properly", menuItem.toString(), appUserInterface.displayTheMenu(menu));
    }

    @Test
    public void menuOptionSelectedIsInvalid() {
        AppMenu appMenu = new AppMenu();
        ArrayList<AppMenuItem> theMenu = new ArrayList<AppMenuItem>();

        AppMenuItem theItem = new AppMenuItem("1", "");
        theMenu.add(theItem);

        assertEquals("Invalid selection not working", "Select a valid option!\n", appUserInterface.menuActionsSelector(appMenu, 2, biblioteca));
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
        for (Movie theMovie : biblioteca.availableMovies) {
            test += theMovie.toString();
        }

        assertEquals("Movies not displaying properly", test, listMoviesItem.displayMovieList(biblioteca));
    }

    @Test
    public void movieCheckoutSuccessful() {
        Movie vinciBook = new Movie("Inferno", "Dan Brown", "2013", "4");
        theLists.availableMovies.add(vinciBook);

        theLists.checkOutMovie("Inferno");

        assertFalse("Book Checkout Unsuccessful", theLists.availableMovies.contains(vinciBook));
    }
}
