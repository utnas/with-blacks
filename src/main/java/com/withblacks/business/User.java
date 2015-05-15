package com.withblacks.business;

public class User {

    private String firstName;
    private String lastName;
    private GENDER gender;

    public User(final String firstName, final String lastName, final GENDER gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public GENDER getGender() {
        return gender;
    }
}
