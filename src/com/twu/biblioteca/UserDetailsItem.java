package com.twu.biblioteca;

/**
 * Created by mcorrales on 7/27/15.
 */
public class UserDetailsItem extends AppMenuItem {
    public UserDetailsItem(String aNumber, String theText) {
        super(aNumber, theText);
    }

    @Override
    public String menuActions(Biblioteca theLists) {
        return null;
    }
}
