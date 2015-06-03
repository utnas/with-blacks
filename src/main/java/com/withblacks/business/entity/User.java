package com.withblacks.business.entity;

import org.springframework.stereotype.Component;

@Component
public class User {

    private String firstName;
    private String lastName;
    private GENDER gender;
    private long id;

    public User() {
    }

    public User(String firstName, String lastName, GENDER gender) {
        this.id = -1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public User(final long id, final String firstName, final String lastName, final GENDER gender) {
        this.id = id;
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

    @Override
    public boolean equals(final Object obj) {
        final User user = (User) obj;
        return firstName.equals(user.firstName) && lastName.equals(user.lastName) && id == user.getId();
    }
}
