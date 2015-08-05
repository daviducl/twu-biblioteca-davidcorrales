package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Created by mcorrales on 8/3/15.
 */
public class MockUsers {

    private ArrayList<User> userList = new ArrayList<User>();

    public MockUsers() {
        User dave = new User("Dave Hal", "dave@hal.com", "222-2222", "123-4567", "password");
        userList.add(dave);
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void addUser(User aUser) {
        userList.add(aUser);
    }

    public User authenticateUser(String userId, String password) {
        for (User user : userList) {
            if (user.matchCredentials(userId, password)){
                return user;
            }
        }
        return null;
    }
}
