package com.twu.biblioteca;

/**
 * Created by mcorrales on 7/18/15.
 */
public class AppMenuItem {
    private String optionNumber;
    private String optionText;

    public AppMenuItem(String aNumber, String theText) {
        optionNumber = aNumber;
        optionText = theText;
    }

    public String toString() {
        return optionNumber + ". " + optionText;
    }

    public String menuActions(Biblioteca theLists) {
        return "";
    }

    public String userActions(User user) { return ""; }
}
