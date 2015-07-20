package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        ArrayList<AppMenuItem> theMenu = new ArrayList<AppMenuItem>();
        AppMenuItem listBooks = new ListBooksItem("1", "List Books");
        AppMenuItem quitApp = new QuitMenuItem("0", "Quit");
        theMenu.add(quitApp);
        theMenu.add(listBooks);


        System.out.println(displayMenuGreeting());
        displayTheMenu(theMenu);
        int menuSelection = readInput("Select an option, please: ");
        while (menuSelection != 0) {
            System.out.print(menuSelector(theMenu, menuSelection));
            menuSelection = readInput("Select an option, please: ");
        }
        System.out.print(theMenu.get(theMenu.indexOf(quitApp)).menuActions());
        //System.out.print(menuSelector(theMenu, menuSelection));
    }

    public static String menuSelector(ArrayList<AppMenuItem> theMenu, int menuSelection) {
        if (menuSelection > theMenu.size() - 1) { return "Select a valid option!\n"; }
        return theMenu.get(menuSelection).menuActions();
    }

    public static String displayMenuGreeting() {
        return "Welcome to the Biblioteca\n";
    }

    public static void displayTheMenu(ArrayList<AppMenuItem> theMenu) {
        for (AppMenuItem menuItem : theMenu) {
            System.out.println(menuItem.toString());
        }
    }

    public static int readInput(String prompt) {
        int inputLine = -1;
        System.out.print(prompt);
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = Integer.parseInt(is.readLine());
        } catch (IOException e) {
            System.err.println("Select a valid option!");
        }
        return inputLine;
    }
}
