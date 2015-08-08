package com.twu.biblioteca;

/**
 * Created by mcorrales on 7/19/15.
 */
public class QuitMenuItem extends AppMenuItem {
    public QuitMenuItem(String aNumber, String theText) {
        super(aNumber, theText);
    }

    @Override
    public String menuActions(Biblioteca theBookLists) {
        return "Thank you for using the Biblioteca\n";
    }
}
