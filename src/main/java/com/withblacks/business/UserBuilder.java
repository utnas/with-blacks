package com.withblacks.business;

import org.springframework.stereotype.Component;

@Component
public class UserBuilder {

    public UserBuilder() {
    }

    public User createUser(final long id, final String firstName, final String lastName, final GENDER gender) {
        // Manage errors here
        return new User(id, firstName, lastName, gender);
    }
}