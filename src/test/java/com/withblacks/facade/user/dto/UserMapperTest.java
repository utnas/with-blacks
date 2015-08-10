package com.withblacks.facade.user.dto;

import com.google.common.collect.Iterables;
import com.withblacks.business.entities.user.User;
import org.junit.Before;
import org.junit.Test;

import static com.google.common.collect.Iterables.getLast;
import static com.withblacks.business.entities.user.GENDER.MALE;
import static com.withblacks.business.layers.user.UserMockHelper.mockUser;
import static com.withblacks.business.layers.user.UserMockHelper.mockUserDto;
import static com.withblacks.rest.utils.MatcherUtils.dtoHasProperties;
import static com.withblacks.rest.utils.MatcherUtils.hasProperties;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertThat;

public class UserMapperTest {

    private UserMapper mapper;

    @Before
    public void setUp() {
        mapper = new UserMapper();
    }

    @Test
    public void testConvertToUser() throws Exception {
        final UserDto dto = mockUserDto("Iron", "Man", MALE);
        assertThat(mapper.convertToUser(dto), hasProperties("Iron", "Man", MALE));
    }

    @Test
    public void testConvertToDto() throws Exception {
        final User user = mockUser("Iron", "Man", MALE);
        assertThat(mapper.convertToDto(user), dtoHasProperties("Iron", "Man", MALE));
    }

    @Test
    public void testConvertToDtos() throws Exception {
        final Iterable<User> users = asList(mockUser("Iron", "Man", MALE));
        assertThat(getLast(mapper.convertToDtos(users)), dtoHasProperties("Iron", "Man", MALE));
    }
}