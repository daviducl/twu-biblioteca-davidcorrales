package com.twu.biblioteca;

/**
 * Created by mcorrales on 7/26/15.
 */
public class UserSignInItem extends AppMenuItem {
    public UserSignInItem(String aNumber, String theText) {
        super(aNumber, theText);
    }

    public boolean userActions(User user) {
        String theCard = InputReader.readString("Card Number? ");
        String thePass = InputReader.readString("Password? ");
        return user.authenticateUser(theCard, thePass);
    }
}
