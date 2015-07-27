package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        User user = new User("Jon Doe", "jon@doe.com", "123-4567", "765-4321", "password");
        ItemLists theLists = new ItemLists();
        ArrayList<AppMenuItem> theMainMenu = new ArrayList<AppMenuItem>();
        ArrayList<AppMenuItem> theUserMenu = new ArrayList<AppMenuItem>();
        AppMenuItem quitApp = new QuitMenuItem("0", "Quit");
        AppMenuItem listBooks = new ListBooksItem("1", "List Books");
        AppMenuItem userSignIn = new UserSignInItem("2", "Sign in to the Library");
        AppMenuItem checkOutBook = new CheckOutBookItem("2", "Checkout Book");
        AppMenuItem checkInBook = new CheckInBookItem("3", "Check In Book");
        AppMenuItem listMovies = new ListMoviesItem("4", "List Movies");
        AppMenuItem checkOutMovie = new CheckOutMovieItem("5", "Checkout Movie");
        AppMenuItem userDetails = new UserDetailsItem("6", "Display User Details");

        theMainMenu.add(quitApp);
        theMainMenu.add(listBooks);
        theMainMenu.add(userSignIn);

        theUserMenu.add(quitApp);
        theUserMenu.add(listBooks);
        theUserMenu.add(checkOutBook);
        theUserMenu.add(checkInBook);
        theUserMenu.add(listMovies);
        theUserMenu.add(checkOutMovie);
        theUserMenu.add(userDetails);

        System.out.println(displayMenuGreeting());
        displayTheMenu(theMainMenu);
        int mainMenuSelection = InputReader.readInteger("Select an option, please: ");
        while (mainMenuSelection != 0) {
            if (mainMenuSelection == 2) {
                if (theMainMenu.get(mainMenuSelection).userActions(user).equals("True")) {
                    System.out.println("Successful Login: Welcome " + user.getName());
                    displayTheMenu(theUserMenu);
                    int userMenuSelection = InputReader.readInteger("Select an option, please: ");
                    while (userMenuSelection != 0) {
                        System.out.print(userMenuSelector(theUserMenu, userMenuSelection, theLists, user));
                        userMenuSelection = InputReader.readInteger("Select an option, please: ");
                    }
                }
            }
            System.out.print(mainMenuSelector(theMainMenu, mainMenuSelection, theLists));
            mainMenuSelection = InputReader.readInteger("Select an option, please: ");
        }
        System.out.print(theMainMenu.get(theMainMenu.indexOf(quitApp)).menuActions(theLists));
    }

    private static String userMenuSelector(ArrayList<AppMenuItem> theUserMenu, int userMenuSelection, ItemLists theLists, User user) {
        if ((userMenuSelection > theUserMenu.size() - 1 || (userMenuSelection < 0))) {
            return "Select a valid option!\n";
        } else if (userMenuSelection == 6){
            return theUserMenu.get(userMenuSelection).userActions(user);
        } else {
            return theUserMenu.get(userMenuSelection).menuActions(theLists);
        }
    }

    public static String mainMenuSelector(ArrayList<AppMenuItem> theMenu, int menuSelection, ItemLists theLists) {
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
