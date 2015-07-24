package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        ItemLists theLists = new ItemLists();
        ArrayList<AppMenuItem> theMenu = new ArrayList<AppMenuItem>();
        AppMenuItem listBooks = new ListBooksItem("1", "List Books");
        AppMenuItem quitApp = new QuitMenuItem("0", "Quit");
        AppMenuItem checkOutBook = new CheckOutBookItem("2", "Checkout Book");
        AppMenuItem checkInBook = new CheckInBookItem("3", "Check In Book");
        AppMenuItem listMovies = new ListMoviesItem("4", "List Movies");
        AppMenuItem checkOutMovie = new CheckOutMovieItem("5", "Checkout Movie");
        theMenu.add(quitApp);
        theMenu.add(listBooks);
        theMenu.add(checkOutBook);
        theMenu.add(checkInBook);
        theMenu.add(listMovies);
        theMenu.add(checkOutMovie);

        System.out.print(theLists.allMovies.get(0).toString());
        System.out.println(displayMenuGreeting());
        displayTheMenu(theMenu);
        int menuSelection = InputReader.readInteger("Select an option, please: ");
        while (menuSelection != 0) {
            System.out.print(menuSelector(theMenu, menuSelection, theLists));
            menuSelection = InputReader.readInteger("Select an option, please: ");
        }
        System.out.print(theMenu.get(theMenu.indexOf(quitApp)).menuActions(theLists));
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
