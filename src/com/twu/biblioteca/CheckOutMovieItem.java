package com.twu.biblioteca;

/**
 * Created by mcorrales on 7/24/15.
 */
public class CheckOutMovieItem extends AppMenuItem {
    public CheckOutMovieItem(String aNumber, String theText) {
        super(aNumber, theText);
    }

    public String menuActions(ItemLists theLists) {
        theLists.checkOutMovie(InputReader.readString("Type a title: "));
        return "\n";
    }

    public String toString() {
        return super.toString();
    }
}
