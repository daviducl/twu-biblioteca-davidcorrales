package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AppUserInterfaceTests {

    private AppUserInterface appUserInterface;
    private MockDatabase mockDatabase;
    private Biblioteca biblioteca;

    @Before
    public void setUp() {
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
        String expected = "";
        for (AppMenuItem menuItem : menu.getMainMenu()) {
            expected += menuItem.toString();
        }
        assertEquals("Main Menu not displaying properly", expected, appUserInterface.displayTheMenu(menu.getMainMenu()));
    }

    @Test
    public void menuOptionSelectedIsInvalid() {
        AppMenu appMenu = new AppMenu();

        assertEquals("Invalid selection not working", "Select a valid option!\n", appUserInterface.menuActionsSelector(appMenu.getMainMenu(), appMenu.getSize() + 1, biblioteca));
    }

    @Test
    public void bookCheckoutSuccessful() {
        Book vinciBook = biblioteca.checkoutBook("Inferno");

        assertFalse("Book Checkout Unsuccessful", biblioteca.getAvailableBooks().contains(vinciBook));
    }

    @Test
    public void bookReturnSuccessful() {
        Book vinciBook = biblioteca.checkoutBook("The Da Vinci Code");
        biblioteca.returnBook("The Da Vinci Code");

        assertTrue("Book Return Unsuccessful", biblioteca.getAvailableBooks().contains(vinciBook));
    }

    @Test
    public void movieListDisplays() {
        String expected = mockDatabase.printMovieList();

        assertEquals("Movies not displaying properly", expected, appUserInterface.displayMovieList(mockDatabase));
    }

    @Test
    public void movieCheckoutSuccessful() {
        Movie infernoMovie = biblioteca.checkoutMovie("Inferno");

        assertFalse("Book Checkout Unsuccessful", biblioteca.getAvailableMovies().contains(infernoMovie));
    }


    @Test
    public void testShouldHaveAUserMenu() {
        AppMenu menu = new AppMenu();
        String expected = "";
        for (AppMenuItem menuItem : menu.getUserMenu()) {
            expected += menuItem.toString();
        }
        assertEquals("Main Menu not displaying properly", expected, appUserInterface.displayTheMenu(menu.getUserMenu()));
    }

//    @Test
//    public void testShouldDisplayUserMenuIfAuthenticated() {
//        AppMenu appMenu = new AppMenu();
//        String expected = appUserInterface.displayTheMenu(appMenu.getUserMenu());
//        String actual = biblioteca.isAuthenticated();
//        assertEquals("User Menu doesn't display after authentication", expected, actual);
//    }
}
