package com.withblacks.business;

public class User {

    private String firstName;
    private String lastName;
    private GENDER gender;
    private long id;

    public User() {
    }

    public User(String firstName, String lastName, GENDER gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public User(long id, final String firstName, final String lastName, final GENDER gender) {
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

    public long getId() {
        return id;
    }
}
