package com.twu.biblioteca;

/**
 * Created by mcorrales on 7/20/15.
 */
public class ReturnBookItem extends AppMenuItem {
    public ReturnBookItem(String aNumber, String aTitle) {
        super(aNumber, aTitle);
    }

    public String menuActions(Biblioteca biblioteca) {
        Book book = biblioteca.returnBook(InputReader.readString("Type a title: "));
        if (book == null)
            return "This is not a valid book to return";
        else
            return "Thank you for returning the book";
    }

    public String toString() {
        return super.toString();
    }
}
