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
            System.out.println(menuActionsSelector(appMenu.getMainMenu(), userSelection, biblioteca));
            System.out.println(displayTheMenu(appMenu.getMainMenu()));
            if (biblioteca.isAuthenticated()){
                System.out.println(menuActionsSelector(appMenu.getUserMenu(), userSelection, biblioteca));
                System.out.println(displayTheMenu(appMenu.getUserMenu()));
            }
            userSelection = InputReader.readInteger("Select an option\n");
        }
        System.out.print("Thank you for using the Biblioteca\n");
    }

    public static String menuActionsSelector(ArrayList<AppMenuItem> theMenu, int menuSelection, Biblioteca biblioteca) {
        if ((menuSelection > theMenu.size() - 1 || (menuSelection < 0))) { return "Select a valid option!\n"; }
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
