package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by mcorrales on 8/2/15.
 */
public class AppMenu {

    private ArrayList<AppMenuItem> mainMenu = new ArrayList<AppMenuItem>();
    private ArrayList<AppMenuItem> userMenu = new ArrayList<AppMenuItem>();

    public AppMenu() {
        AppMenuItem quitApp = new QuitMenuItem("0", "Quit\n");
        AppMenuItem listBooks = new ListBooksItem("1", "List Books\n");
        AppMenuItem userSignIn = new UserSignInItem("2", "Sign In\n");

        AppMenuItem checkOutBook = new CheckOutBookItem("2", "Checkout Book\n");
        AppMenuItem returnBook = new ReturnBookItem("3", "Check In Book\n");
        AppMenuItem listMovies = new ListMoviesItem("4", "List Movies\n");
        AppMenuItem checkoutMovie = new CheckOutMovieItem("5", "Checkout Movie\n");
        AppMenuItem userDetails = new UserDetailsItem("6", "Display User Details\n");

        mainMenu.add(quitApp);
        mainMenu.add(listBooks);
        mainMenu.add(userSignIn);

        userMenu.add(quitApp);
        userMenu.add(listBooks);
        userMenu.add(checkOutBook);
        userMenu.add(returnBook);
        userMenu.add(listMovies);
        userMenu.add(checkoutMovie);
        userMenu.add(userDetails);
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

    public ArrayList<AppMenuItem> getUserMenu() {
        return userMenu;
    }
}
