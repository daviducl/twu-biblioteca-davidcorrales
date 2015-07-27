package com.twu.biblioteca;

/**
 * Created by mcorrales on 7/27/15.
 */
public class UserDetailsItem extends AppMenuItem {
    public UserDetailsItem(String aNumber, String theText) {
        super(aNumber, theText);
    }

    public String userActions(User user) {
        return user.toString();
    }

    public String toString() {
        return super.toString();
    }
}
