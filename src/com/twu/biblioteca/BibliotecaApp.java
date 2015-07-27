package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        ItemLists theLists = new ItemLists();
        ArrayList<AppMenuItem> theMainMenu = new ArrayList<AppMenuItem>();
        ArrayList<AppMenuItem> theUserMenu = new ArrayList<AppMenuItem>();
        AppMenuItem quitApp = new QuitMenuItem("0", "Quit");
        AppMenuItem listBooks = new ListBooksItem("1", "List Books");
        AppMenuItem userSignIn = new UserSignInItem("2", "Sign in to the Library");
        AppMenuItem userSignOut = new UserSignOutItem("1", "Sign out");
        AppMenuItem checkOutBook = new CheckOutBookItem("2", "Checkout Book");
        AppMenuItem checkInBook = new CheckInBookItem("3", "Check In Book");
        AppMenuItem listMovies = new ListMoviesItem("4", "List Movies");
        AppMenuItem checkOutMovie = new CheckOutMovieItem("5", "Checkout Movie");
        theMainMenu.add(quitApp);
        theMainMenu.add(listBooks);
        theMainMenu.add(checkOutBook);
        theMainMenu.add(checkInBook);
        theMainMenu.add(listMovies);
        theMainMenu.add(checkOutMovie);

        System.out.println(displayMenuGreeting());
        displayTheMenu(theMainMenu);
        int menuSelection = InputReader.readInteger("Select an option, please: ");
        while (menuSelection != 0) {
            System.out.print(menuSelector(theMainMenu, menuSelection, theLists));
            menuSelection = InputReader.readInteger("Select an option, please: ");
        }
        System.out.print(theMainMenu.get(theMainMenu.indexOf(quitApp)).menuActions(theLists));
    }

    public static String menuSelector(ArrayList<AppMenuItem> theMenu, int menuSelection, ItemLists theLists) {
        if ((menuSelection > theMenu.size() - 1 || (menuSelection < 0))) { return "Select a valid option!\n"; }
        return theMenu.get(menuSelection).menuActions(theLists);
    }

    public static String displayMenuGreeting() {
        return "Welcome to the Biblioteca\n";
    }

    public static void displayTheMenu(ArrayList<AppMenuItem> theMenu) {
        for (AppMenuItem menuItem : theMenu) {
            System.out.println(menuItem.toString());
        }
    }

}
