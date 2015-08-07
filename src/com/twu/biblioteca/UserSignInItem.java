package com.twu.biblioteca;

/**
 * Created by mcorrales on 7/26/15.
 */
public class UserSignInItem extends AppMenuItem {
    public UserSignInItem(String aNumber, String theText) {
        super(aNumber, theText);
    }

    public String menuActions(Biblioteca biblioteca) {
        String theCard = InputReader.readString("Card Number? ");
        String thePass = InputReader.readString("Password? ");
        User user = biblioteca.authenticateUser(theCard, thePass);
        if (user == null)
            return "Wrong username or password";
        else
            return "Welcome " + user.getName();
    }
}
su