package com.twu.biblioteca;

/**
 * Created by mcorrales on 7/20/15.
 */
public class ReturnBookItem extends AppMenuItem {
    public ReturnBookItem(String aNumber, String aTitle) {
        super(aNumber, aTitle);
    }

    public String menuActions(Biblioteca biblioteca) {
        biblioteca.returnBook(InputReader.readString("Type a title: "));
        return "\n";
    }

    public String toString() {
        return super.toString();
    }
}
