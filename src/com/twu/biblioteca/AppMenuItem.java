package com.twu.biblioteca;

/**
 * Created by mcorrales on 7/18/15.
 */
public class AppMenuItem {
    private String optionNumber;
    private String optionText;

    public AppMenuItem() {
        optionNumber = optionText = "";
    }
    public AppMenuItem(String aNumber, String theText) {
        optionNumber = aNumber;
        optionText = theText;
    }

    public void setOptionNumber(String aNumber) { optionNumber = aNumber; }
    public void setOptionText(String theText) { optionText = theText; }

    public String getOptionNumber() { return optionNumber; }
    public String getOptionText() { return optionText; }

    public String toString() {
        return optionNumber + ". " + optionText;
    }

    public String menuActions(BookLists theBookLists) {
        return "";
    }
}
