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
        System.out.print("Thank you for using the Biblioteca\n");
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
