package com.twu.biblioteca;

import java.util.ArrayList;

public class AppUserInterface {

    public static void main(String[] args) {
        MockDatabase mockDatabase = new MockDatabase();
        Biblioteca biblioteca = new Biblioteca(mockDatabase);
        AppMenu appMenu = new AppMenu();

        System.out.print(displayMenuGreeting());
        System.out.print(displayTheMenu(appMenu.getMainMenu()));

        int userSelection = InputReader.readInteger("Select an option\n");
        while (userSelection != 0) {
            System.out.println(menuActionsSelector(appMenu, userSelection, biblioteca));
            userSelection = InputReader.readInteger("Select an option\n");
        }

        /*
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
            System.out.print(menuActionsSelector(theMainMenu, mainMenuSelection, theLists));
            mainMenuSelection = InputReader.readInteger("Select an option, please: ");
        }
        System.out.print(theMainMenu.get(theMainMenu.indexOf(quitApp)).menuActions(theLists));*/
    }

    private static String userMenuSelector(ArrayList<AppMenuItem> theUserMenu, int userMenuSelection, Biblioteca biblioteca, User user) {
        if ((userMenuSelection > theUserMenu.size() - 1 || (userMenuSelection < 0))) {
            return "Select a valid option!\n";
        } else if (userMenuSelection == 6){
            return theUserMenu.get(userMenuSelection).userActions(user);
        } else {
            return theUserMenu.get(userMenuSelection).menuActions(biblioteca);
        }
    }

    public static String menuActionsSelector(AppMenu theMenu, int menuSelection, Biblioteca biblioteca) {
        if ((menuSelection > theMenu.getSize() - 1 || (menuSelection < 0))) { return "Select a valid option!\n"; }
        return theMenu.get(menuSelection).menuActions(biblioteca);
    }

    public static String displayMenuGreeting() {
        return "Welcome to the Biblioteca\n";
    }

    public static String displayTheMenu(ArrayList<AppMenuItem> theMenu) {
        String display = "";
        for (AppMenuItem menuItem : theMenu) {
            display += menuItem.toString();
        }
        return display;
    }

    public static String displayBookList(MockDatabase mockDatabase) {
        return mockDatabase.printBookList();
    }

    public String displayMovieList(MockDatabase mockDatabase) {
        return mockDatabase.printMovieList();
    }
}
