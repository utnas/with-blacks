package com.withblacks.rest.user.trasformer;

import com.google.common.collect.Iterables;
import com.withblacks.business.entity.GENDER;
import com.withblacks.business.entity.User;
import com.withblacks.rest.user.UserRestImpl;
import com.withblacks.rest.user.dto.UserResource;
import com.withblacks.rest.user.dto.mapper.UserResourceBuilder;
import com.withblacks.rest.user.dto.mapper.UserMapperImpl;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Optional;

import static com.google.common.collect.Iterables.isEmpty;
import static com.withblacks.business.entity.GENDER.FEMALE;
import static com.withblacks.repository.data.UserGenerator.generateUsers;
import static java.util.Collections.EMPTY_LIST;
import static java.util.Optional.empty;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;

public class UserMapperImplTest {

    @Test
    public void testItShouldConvertUsersListToUserDtoEmptyList() throws Exception {
       final Iterable<UserResource> userResources = new UserMapperImpl().convertTo(EMPTY_LIST, empty());
        assertThat(isEmpty(userResources), is(true));
    }

    @Test
    public void testItShouldConvertUsersListToUserDtoList() throws Exception {
        final Iterable<UserResource> userResources = new UserMapperImpl().convertTo(generateUsers(5), empty());
        assertThat(userResources, containsOnlyUserDto());
    }

    @Test
    public void testItShouldConvertUserToUserDto() throws Exception {
        final UserResource userResource = new UserMapperImpl().convertTo(generateUsers(1).get(0), empty());
        assertThat(userResource == null, is(false));
    }

    @Test
    public void testConvertFrom() throws Exception {
        final UserResource userResourceBuilder = UserResourceBuilder.build("FirstName", "LastName", FEMALE);
        final User user = new UserMapperImpl().convertFrom(userResourceBuilder);
        assertThat(user, hasProperties("FirstName", "LastName", FEMALE));
    }

    private Matcher<User> hasProperties(final String firstName, final String lastName, final GENDER gender) {
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

    private Matcher<Iterable<UserResource>> containsOnlyUserDto() {
        return new BaseMatcher<Iterable<UserResource>>() {
            @Override
            public boolean matches(final Object item) {
                for (final Object o : ((ArrayList) item)) {
                    if (!(o instanceof UserResource)) {
                        return false;
                    }
                }
                return true;
            }

            @Override
            public void describeTo(final Description description) {

            }
        };
    }
}