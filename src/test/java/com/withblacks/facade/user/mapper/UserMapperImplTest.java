package com.withblacks.facade.user.mapper;

import com.google.common.collect.Iterables;
import com.withblacks.business.entity.GENDER;
import com.withblacks.business.entity.User;
import com.withblacks.rest.user.dto.UserResource;
import com.withblacks.rest.user.utils.MatcherUtils;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;

import static com.google.common.collect.Iterables.isEmpty;
import static com.withblacks.business.entity.GENDER.FEMALE;
import static com.withblacks.facade.user.mapper.UserResourceBuilder.build;
import static com.withblacks.repository.data.UserGenerator.generateUsers;
import static java.util.Collections.EMPTY_LIST;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class UserMapperImplTest {

    @Test
    public void testItShouldConvertUsersListToUserDtoEmptyList() throws Exception {
        final Iterable<UserResource> userResources = new UserMapperImpl().convertTo(EMPTY_LIST);
        assertThat(isEmpty(userResources), Matchers.is(true));
    }

    @Test
    public void testItShouldConvertUsersListToUserDtoList() throws Exception {
        final Iterable<UserResource> userResources = new UserMapperImpl().convertTo(generateUsers(5));
        assertThat(userResources, containsOnlyUserDto());
    }

    @Test
    public void testItShouldConvertUserToUserDto() throws Exception {
        UserResource build = build(0, "", "", GENDER.MALE);
        final UserResource userResource = new UserMapperImpl().convertTo((User) Iterables.getFirst(generateUsers(1), build));
        assertNotNull(userResource);
    }

    @Test
    public void testConvertFrom() throws Exception {
        final UserResource userResourceBuilder = build("FirstName", "LastName", FEMALE);
        final User user = new UserMapperImpl().convertFrom(userResourceBuilder);
        assertThat(user, MatcherUtils.hasProperties("FirstName", "LastName", FEMALE));
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