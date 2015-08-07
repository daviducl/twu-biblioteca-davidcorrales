package com.twu.biblioteca;

/**
 * Created by mcorrales on 7/18/15.
 */
public abstract class AppMenuItem {
    private String optionNumber;
    private String optionText;

    public AppMenuItem(String aNumber, String theText) {
        optionNumber = aNumber;
        optionText = theText;
    }

    public String toString() {
        return optionNumber + ". " + optionText;
    }

    public abstract String menuActions(Biblioteca theLists);
}
