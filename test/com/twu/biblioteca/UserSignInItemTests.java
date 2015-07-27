package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mcorrales on 7/26/15.
 */
public class UserSignInItemTests {

    User user;

    @Before
    public void setUp() throws Exception {
        user = new User("Jon Doe", "jon@doe.com", "123-4567", "765-4321", "password");
    }

    @Test
    public void testUserPasswordAuthenticationValid() {
        boolean actual = user.authenticateUser("765-4321", "password");

        assertEquals("User/Pass don't match", true, actual);
    }

    @Test
    public void testCardNumberWithWrongFormatCantBeSet() {
        String wrongCard = "23094";

        assertFalse("Card Number format is incorrect", user.setCardNumber(wrongCard));
    }

    @Test
    public void testCardNumberWithRightFormatCanBeSet() {
        String rightCard = "123-4567";

        assertTrue("Card Number regex is incorrect", user.setCardNumber(rightCard));
    }
}
