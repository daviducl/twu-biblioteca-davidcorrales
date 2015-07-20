package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        ArrayList<BookDetails> bookList = new ArrayList<BookDetails>();
        BookDetails book = new BookDetails("Inferno", "Dan Brown", "2013");
        bookList.add(book);

        ArrayList<AppMenuItem> theMenu = new ArrayList<AppMenuItem>();
        AppMenuItem listBooks = new ListBooksItem("1", "List Books");
        AppMenuItem quitApp = new QuitMenuItem("0", "Quit");
        theMenu.add(quitApp);
        theMenu.add(listBooks);


        System.out.println(displayMenuGreeting());
        displayTheMenu(theMenu);
        int menuSelection = readInput("Select an option, please: ");
        System.out.print(menuSelector(theMenu, menuSelection));

    }

    public static String menuSelector(ArrayList<AppMenuItem> theMenu, int menuSelection) {
        String menuString = "";
        int menuOptions = theMenu.size();
        if ((menuSelection < 0) || (menuSelection > menuOptions)) {
            System.out.println("Select a valid option!");
            menuSelector(theMenu, readInput("Select an option, please: "));
            return "";
        }
        while (menuSelection != 0 && menuSelection < menuOptions) {
            menuString = theMenu.get(menuSelection).menuActions();
            System.out.print(menuString);
            menuSelection = readInput("Select an option, please: ");
        }
        menuString = theMenu.get(0).menuActions();
        return menuString;
    }

    public static String displayMenuGreeting() {
        return "Welcome to the Biblioteca\n";
    }

    public static void displayTheMenu(ArrayList<AppMenuItem> theMenu) {
        for (AppMenuItem menuItem : theMenu) {
            System.out.println(menuItem.toString());
        }
    }

    public static String displayBookList(ArrayList<BookDetails> bookList) {
        String books = "These are our books:\n";
        for (BookDetails bookDetails : bookList) {
            books += bookDetails.toString();
        }
        return books;
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
