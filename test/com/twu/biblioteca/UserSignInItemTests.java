package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        boolean actual = user.authenticateUser("password");

        assertEquals("User/Pass don't match", true, actual);
    }
}
