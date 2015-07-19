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
        AppMenuItem menuItem = new AppMenuItem("1", "List Books");
        theMenu.add(menuItem);

        System.out.println(displayMenuGreeting());
        displayTheMenu(theMenu);
        menuSelect(bookList);

    }

    public static void menuSelect(ArrayList<BookDetails> bookList) {
        int menuSelection = readInput("Select an option, please: ");
        int menuOptions = bookList.size();
        if (menuSelection > menuOptions) {
            System.out.print("Select a valid option!");
        } else {
            System.out.print(displayBookList(bookList));
        }
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
