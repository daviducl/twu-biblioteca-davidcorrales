package com.twu.biblioteca;

/**
 * Created by mcorrales on 7/19/15.
 */
public class CheckOutBookItem extends AppMenuItem {
    public CheckOutBookItem(String aNumber, String theText) {
        super(aNumber, theText);
    }

    public String menuActions(Biblioteca biblioteca) {
        Book book = biblioteca.checkoutBook(InputReader.readString("Type a title: "));
        if (book == null)
            return "That book is not available";
        else
            return "Thank you! Enjoy the book";
    }

    public String toString() {
        return super.toString();
    }
}
