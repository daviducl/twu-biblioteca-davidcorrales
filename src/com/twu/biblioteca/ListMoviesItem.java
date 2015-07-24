package com.twu.biblioteca;

/**
 * Created by mcorrales on 7/19/15.
 */
public class ListMoviesItem extends AppMenuItem {
    public ListMoviesItem(String aNumber, String theText){
        super(aNumber, theText);
    }

    public String menuActions(BookLists theBookLists) {
        return displayMovieList(theBookLists);
    }

    public String toString() {
        return super.toString();
    }

    public static String displayMovieList(BookLists theBookLists) {
        String books = "These are our books:\n";
        for (Book bookDetails : theBookLists.availableBooks) {
            books += bookDetails.toString();
        }
        return books;
    }
}
