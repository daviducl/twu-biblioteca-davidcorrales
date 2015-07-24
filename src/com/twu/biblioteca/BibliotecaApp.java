package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        ItemLists theBookLists = new BookLists();
        ItemLists theMovieLists = new MovieLists();
        ArrayList<AppMenuItem> theMenu = new ArrayList<AppMenuItem>();
        AppMenuItem listBooks = new ListBooksItem("1", "List Books");
        AppMenuItem quitApp = new QuitMenuItem("0", "Quit");
        AppMenuItem checkOutBook = new CheckOutBookItem("2", "Checkout Book");
        AppMenuItem checkInBook = new CheckInBookItem("3", "Check In Book");
        AppMenuItem listMovies = new ListBooksItem("4", "List Movies");
        theMenu.add(quitApp);
        theMenu.add(listBooks);
        theMenu.add(checkOutBook);
        theMenu.add(checkInBook);
        theMenu.add(listMovies);

        System.out.println(displayMenuGreeting());
        displayTheMenu(theMenu);
        int menuSelection = InputReader.readInteger("Select an option, please: ");
        while (menuSelection != 0) {
            if (menuSelection > 0 && menuSelection < 4) {
                System.out.print(menuSelector(theMenu, menuSelection, theBookLists));
            } else {
                System.out.print(menuSelector(theMenu, menuSelection, theMovieLists));
            }
            menuSelection = InputReader.readInteger("Select an option, please: ");
        }
        System.out.print(theMenu.get(theMenu.indexOf(quitApp)).menuActions(theBookLists));
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
