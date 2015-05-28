package com.withblacks.business.builder;

import com.withblacks.business.entity.GENDER;
import com.withblacks.business.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserBuilder {

    public UserBuilder() {
    }

    public static User build(final long id, final String firstName, final String lastName, final GENDER gender) {
        // Manage errors here
        return new User(id, firstName, lastName, gender);
    }

    public static User build(final String firstName, final String lastName, final GENDER gender) {
        // Manage errors here
        return new User(-1, firstName, lastName, gender);
    }
}