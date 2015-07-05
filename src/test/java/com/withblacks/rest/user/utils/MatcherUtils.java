package com.withblacks.rest.user.utils;

import com.withblacks.business.entity.GENDER;
import com.withblacks.business.entity.User;
import com.withblacks.rest.user.dto.UserResource;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class MatcherUtils {

    public static Matcher<User> hasProperties(final String firstName, final String lastName, final GENDER gender) {
        return new BaseMatcher<User>() {
            @Override
            public boolean matches(final Object item) {
                User user = (User) item;
                return user.getFirstName().equals(firstName) && user.getLastName().equals(lastName) && user.getGender().equals(gender);
            }

            @Override
            public void describeTo(Description description) {

            }
        };
    }

    public static Matcher<User> hasProperties(final Long id, final String firstName, final String lastName, final GENDER gender) {
        return new BaseMatcher<User>() {
            @Override
            public boolean matches(final Object item) {
                User user = (User) item;
                return user.getId().equals(id) && user.getFirstName().equals(firstName) && user.getLastName().equals(lastName) && user.getGender().equals(gender);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("properties not found");
            }
        };
    }

    public static Matcher<UserResource> resourceHasProperties(final Long id, final String firstName, final String lastName, final GENDER gender) {
        return new BaseMatcher<UserResource>() {
            @Override
            public boolean matches(final Object item) {
                UserResource user = (UserResource) item;
                return user.getIds().equals(id) && user.getFirstName().equals(firstName) && user.getLastName().equals(lastName) && user.getGender().equals(gender);
            }

            @Override
            public void describeTo(Description description) {

            }
        };
    }
}
