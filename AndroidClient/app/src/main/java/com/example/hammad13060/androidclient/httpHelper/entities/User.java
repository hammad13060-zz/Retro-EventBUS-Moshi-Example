package com.example.hammad13060.androidclient.httpHelper.entities;

/**
 * Created by hammad13060 on 27/04/16.
 */
public class User {
    public String firstName;
    public String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
