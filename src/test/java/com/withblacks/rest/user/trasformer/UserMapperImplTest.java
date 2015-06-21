package com.withblacks.rest.user.trasformer;

import com.withblacks.business.entity.User;
import com.withblacks.rest.user.dto.UserResource;
import com.withblacks.rest.user.dto.mapper.UserMapperImpl;
import com.withblacks.rest.user.dto.mapper.UserResourceBuilder;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.ArrayList;

import static com.google.common.collect.Iterables.isEmpty;
import static com.withblacks.business.entity.GENDER.FEMALE;
import static com.withblacks.repository.data.UserGenerator.generateUsers;
import static com.withblacks.rest.user.utils.MatcherUtils.hasProperties;
import static java.util.Collections.EMPTY_LIST;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;

public class UserMapperImplTest {

    @Test
    public void testItShouldConvertUsersListToUserDtoEmptyList() throws Exception {
        final Iterable<UserResource> userResources = new UserMapperImpl().convertTo(EMPTY_LIST);
        assertThat(isEmpty(userResources), is(true));
    }

    @Test
    public void testItShouldConvertUsersListToUserDtoList() throws Exception {
        final Iterable<UserResource> userResources = new UserMapperImpl().convertTo(generateUsers(5));
        assertThat(userResources, containsOnlyUserDto());
    }

    @Test
    public void testItShouldConvertUserToUserDto() throws Exception {
        final UserResource userResource = new UserMapperImpl().convertTo(generateUsers(1).get(0));
        assertThat(userResource == null, is(false));
    }

    @Test
    public void testConvertFrom() throws Exception {
        final UserResource userResourceBuilder = UserResourceBuilder.build("FirstName", "LastName", FEMALE);
        final User user = new UserMapperImpl().convertFrom(userResourceBuilder);
        assertThat(user, hasProperties("FirstName", "LastName", FEMALE));
    }


    private Matcher<Iterable<UserResource>> containsOnlyUserDto() {
        return new BaseMatcher<Iterable<UserResource>>() {
            @Override
            public boolean matches(final Object item) {
                for (final Object o : ((ArrayList<? extends Object>) item)) {
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