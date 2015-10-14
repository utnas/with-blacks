package com.withblacks.api.rest.utils;

import com.withblacks.api.business.entities.user.GENDER;
import com.withblacks.api.business.entities.user.User;
import com.withblacks.api.facade.user.dto.UserDto;
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
                final User user = (User) item;
                return user.getId() == (id)
                        && user.getFirstName().equals(firstName)
                        && user.getLastName().equals(lastName)
                        && user.getGender().equals(gender);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("properties not found");
            }
        };
    }

    public static Matcher<UserDto> dtoHasProperties(final String firstName, final String lastName, final GENDER gender) {
        return new BaseMatcher<UserDto>() {
            @Override
            public boolean matches(final Object item) {
                UserDto user = (UserDto) item;
                return user.getFirstName().equals(firstName) && user.getLastName().equals(lastName) && user.getGender().equals(gender);
            }

            @Override
            public void describeTo(Description description) {

            }
        };
    }
}
