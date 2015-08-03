package com.twu.biblioteca;

/**
 * Created by mcorrales on 7/19/15.
 */
public class ListBooksItem extends AppMenuItem {
    public ListBooksItem(String aNumber, String theText){
        super(aNumber, theText);
    }

    public String menuActions(Biblioteca biblioteca) {
        return displayBookList(biblioteca);
    }

    public String toString() {
        return super.toString();
    }

    public static String displayBookList(Biblioteca biblioteca) {
        String books = "These are our books:\n";
        for (Book book : biblioteca.getBookList()) {
            books += book.toString();
        }
        return books;
    }
}
