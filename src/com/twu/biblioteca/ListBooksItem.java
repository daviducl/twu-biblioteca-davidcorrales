package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by mcorrales on 7/19/15.
 */
public class ListBooksItem extends AppMenuItem {
    public ListBooksItem(String aNumber, String theText){
        super(aNumber, theText);
    }
    public String menuActions(BookLists theBookLists) {
        return displayBookList(theBookLists);
    }

    public String toString() {
        return super.toString();
    }

    public static String displayBookList(BookLists theBookLists) {
        String books = "These are our books:\n";
        for (BookDetails bookDetails : theBookLists.availableBooks) {
            books += bookDetails.toString();
        }
        return books;
    }
}
