package com.twu.biblioteca;

/**
 * Created by mcorrales on 7/26/15.
 */
public class UserSignOutItem extends AppMenuItem {
    public UserSignOutItem(String aNumber, String theText) {
        super(aNumber, theText);
    }

    public String menuAction(ItemLists theLists) {
        return "";
    }

    public String toString() {
        return super.toString();
    }
}
