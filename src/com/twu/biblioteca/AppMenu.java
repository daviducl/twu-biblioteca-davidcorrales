package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by mcorrales on 8/2/15.
 */
public class AppMenu {

    private ArrayList<AppMenuItem> mainMenu = new ArrayList<AppMenuItem>();

    public AppMenu() {
        AppMenuItem quitApp = new QuitMenuItem("0", "Quit\n");
        AppMenuItem listBooks = new ListBooksItem("1", "List Books\n");
        AppMenuItem checkOutBook = new CheckOutBookItem("2", "Checkout Book\n");
        AppMenuItem returnBook = new ReturnBookItem("3", "Check In Book\n");
        AppMenuItem listMovies = new ListMoviesItem("4", "List Movies\n");
        AppMenuItem checkoutMovie = new CheckOutMovieItem("5", "Checkout Movie\n");

        mainMenu.add(quitApp);
        mainMenu.add(listBooks);
        mainMenu.add(checkOutBook);
        mainMenu.add(returnBook);
        mainMenu.add(listMovies);
        mainMenu.add(checkoutMovie);
    }

    public ArrayList<AppMenuItem> getMainMenu(){
        return mainMenu;
    }

    public int getSize() {
        return mainMenu.size();
    }

    public AppMenuItem get(int menuSelection) {
        return mainMenu.get(menuSelection);
    }
}
