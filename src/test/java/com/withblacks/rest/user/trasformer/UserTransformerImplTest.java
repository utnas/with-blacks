package com.withblacks.rest.user.trasformer;

import com.withblacks.business.entity.GENDER;
import com.withblacks.business.entity.User;
import com.withblacks.rest.user.UserResource;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.ArrayList;

import static com.google.common.collect.Iterables.isEmpty;
import static com.withblacks.business.entity.GENDER.FEMALE;
import static com.withblacks.repository.data.UserGenerator.generateUsers;
import static java.util.Collections.EMPTY_LIST;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;

public class UserTransformerImplTest {

    @Test
    public void testItShouldConvertUsersListToUserDtoEmptyList() throws Exception {
        Iterable<UserResource> userDtos = new UserTransformerImpl().convertTo(EMPTY_LIST);
        assertThat(isEmpty(userDtos), is(true));
    }

    @Test
    public void testItShouldConvertUsersListToUserDtoList() throws Exception {
        Iterable<UserResource> userDtos = new UserTransformerImpl().convertTo(generateUsers(5));
        assertThat(userDtos, containsOnlyUserDto());
    }

    @Test
    public void testItShouldConvertUserToUserDto() throws Exception {
        UserResource userResource = new UserTransformerImpl().convertTo(generateUsers(1).get(0));
        assertThat(userResource == null, is(false));
    }

    @Test
    public void testConvertFrom() throws Exception {
        UserResource userResourceBuilder = UserDtoBuilder.build("FirstName", "LastName", FEMALE);
        User user = new UserTransformerImpl().convertFrom(userResourceBuilder);
        assertThat(user, hasProperties("FirstName", "LastName", FEMALE));
    }

    private Matcher<User> hasProperties(final String firstName, final String lastName, final GENDER gender) {
        return new BaseMatcher<User>() {
            @Override
            public boolean matches(Object item) {
                User user = (User) item;
                return user.getFirstName().equals(firstName) && user.getLastName().equals(lastName) && user.getGender().equals(gender);
            }

            @Override
            public void describeTo(Description description) {

            }
        };
    }

    private Matcher<Iterable<UserResource>> containsOnlyUserDto() {
        return new BaseMatcher<Iterable<UserResource>>() {
            @Override
            public boolean matches(Object item) {
                for (final Object o : ((ArrayList) item)) {
                    if (!(o instanceof UserResource)) {
                        return false;
                    }
                }
                return true;
            }

            @Override
            public void describeTo(Description description) {

            }
        };
    }
}