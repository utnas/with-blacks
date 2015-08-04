package com.withblacks.business.builder;

import com.withblacks.business.entities.GENDER;
import com.withblacks.business.entities.User;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class UserBuilder {

    private String firstName;
    private String lastName;
    private GENDER gender;

    public UserBuilder() {
    }

    public static User build(final String firstName, final String lastName, final GENDER gender) {
        notNull(firstName + " , " + lastName + " , " + gender + " , are null.", firstName, lastName, gender);

        final User user = new User();
        user.setGender(gender);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        return user;
    }

    private static void notNull(final String message, final Object... values) {
        for (final Object value : values) {
            Assert.notNull(value, message);
        }
    }

    public User build() {
        final User user = new User();

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setGender(getGender());

        return user;
    }


    public UserBuilder setFirstName(final String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserBuilder setLastName(final String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserBuilder setGender(final GENDER gender) {
        this.gender = gender;
        return this;
    }

    public GENDER getGender() {
        return gender;
    }
}
