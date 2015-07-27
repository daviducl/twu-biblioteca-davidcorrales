package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mcorrales on 7/24/15.
 */
public class UserTests {

    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User("Jon Doe", "jon@doe.com", "123-4567", "765-4321", "password");
    }

    @Test
    public void testPrintOutUserInfo() {
        String expected = "Name: Jon Doe\nE-Mail: jon@doe.com\nPhone Number: 123-4567\n";
        expected += "Card Number: 765-4321\nPassword: password\n";
        String actual = user.toString();

        assertEquals("User info not displayed properly", expected, actual);
    }
}
