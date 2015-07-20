package com.twu.biblioteca;

/**
 * Created by mcorrales on 7/19/15.
 */
public class ListBooksItem extends AppMenuItem {

    public ListBooksItem(String aNumber, String theText){
        super(aNumber, theText);
    }
    public String menuActions() {
        return "List Book actions";
    }

    public String toString() {
        return super.toString();
    }
}
