package com.twu.biblioteca;

/**
 * Created by mcorrales on 7/19/15.
 */
public class CheckOutBookItem extends AppMenuItem {
    public CheckOutBookItem(String aNumber, String theText) {
        super(aNumber, theText);
    }

    public String menuActions() {
        return "CheckOut actions";
    }

    public String toString() {
        return super.toString();
    }
}
