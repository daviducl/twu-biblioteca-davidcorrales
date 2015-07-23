package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        BookLists theBookLists = new BookLists();
        MovieLists theMovieLists = new MovieLists();
        ArrayList<AppMenuItem> theMenu = new ArrayList<AppMenuItem>();
        AppMenuItem listBooks = new ListBooksItem("1", "List Books");
        AppMenuItem quitApp = new QuitMenuItem("0", "Quit");
        AppMenuItem checkOutBook = new CheckOutBookItem("2", "Checkout Book");
        AppMenuItem checkInBook = new CheckInBookItem("3", "Check In Book");
        theMenu.add(quitApp);
        theMenu.add(listBooks);
        theMenu.add(checkOutBook);
        theMenu.add(checkInBook);


        System.out.println(displayMenuGreeting());
        displayTheMenu(theMenu);
        int menuSelection = InputReader.readInteger("Select an option, please: ");
        while (menuSelection != 0) {
            System.out.print(menuSelector(theMenu, menuSelection, theBookLists));
            menuSelection = InputReader.readInteger("Select an option, please: ");
        }
        System.out.print(theMenu.get(theMenu.indexOf(quitApp)).menuActions(theBookLists));
    }

    public static String menuSelector(ArrayList<AppMenuItem> theMenu, int menuSelection, BookLists theBookLists) {
        if ((menuSelection > theMenu.size() - 1 || (menuSelection < 0))) { return "Select a valid option!\n"; }
        return theMenu.get(menuSelection).menuActions(theBookLists);
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
