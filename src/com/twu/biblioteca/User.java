package com.twu.biblioteca;

/**
 * Created by mcorrales on 7/24/15.
 */
public class User {
    private String name;
    private String eMail;
    private String phoneNumber;
    private String cardNumber;
    private String password;

    public User(String aName, String anEmail, String aNumber, String aCard, String aPassword) {
        name = aName;
        eMail = anEmail;
        phoneNumber = aNumber;
        cardNumber = aCard;
        password = aPassword;
    }

    public String toString(){
        String toReturn = "Name: " + name + "\n";
        toReturn += "E-Mail: " + eMail + "\n";
        toReturn += "Phone Number: " + phoneNumber + "\n";
        toReturn += "Card Number: " + cardNumber + "\n";
        toReturn += "Password: " + password + "\n";
        return toReturn;
    }

    public boolean authenticateUser(String theUser, String thePassword) {
        return cardNumber == theUser && password == thePassword;
    }
}
