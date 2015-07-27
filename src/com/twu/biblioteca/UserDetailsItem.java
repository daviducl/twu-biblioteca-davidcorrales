package com.twu.biblioteca;

/**
 * Created by mcorrales on 7/27/15.
 */
public class UserDetailsItem extends AppMenuItem {
    public UserDetailsItem(String aNumber, String theText) {
        super(aNumber, theText);
    }

    public boolean userActions(User user) {
        user.toString();
        return true;
    }

    public String toString() {
        return super.toString();
    }
}
