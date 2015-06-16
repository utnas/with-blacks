package com.withblacks.business.builder;

import com.withblacks.business.entity.GENDER;
import com.withblacks.business.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class UserBuilder {

    public UserBuilder() {
    }

    public static User build(final long id, final String firstName, final String lastName, final GENDER gender) {
        notNull(id + " , " + firstName + " , " + lastName + " , " + gender + " , are null.", id, firstName, lastName, gender);
        return new User(id, firstName, lastName, gender);
    }

    public static User build(final String firstName, final String lastName, final GENDER gender) {
        notNull(firstName + " , " + lastName + " , " + gender + " , are null.", firstName, lastName, gender);
        return new User(-1, firstName, lastName, gender);
    }

    private static void notNull(final String message, final Object... values) {
        for (final Object value : values) {
            Assert.notNull(value, message);
        }
    }
}