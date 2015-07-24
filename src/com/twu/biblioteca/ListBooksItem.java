package com.twu.biblioteca;

/**
 * Created by mcorrales on 7/19/15.
 */
public class ListBooksItem extends AppMenuItem {
    public ListBooksItem(String aNumber, String theText){
        super(aNumber, theText);
    }

    public String menuActions(ItemLists theLists) {
        return displayBookList(theLists);
    }

    public String toString() {
        return super.toString();
    }

    public static String displayBookList(ItemLists theBookLists) {
        String books = "These are our books:\n";
        for (Book book : theBookLists.availableBooks) {
            books += book.toString();
        }
        return books;
    }
}
