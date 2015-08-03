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
        mainMenu.add(quitApp);
        mainMenu.add(listBooks);
    }

    public void add(AppMenuItem menuItem) {
        mainMenu.add(menuItem);
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
