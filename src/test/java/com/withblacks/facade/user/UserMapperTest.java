package com.withblacks.facade.user;

import com.google.common.collect.Iterables;
import com.withblacks.business.entities.User;
import com.withblacks.facade.user.UserMapper;
import com.withblacks.rest.user.dto.UserDto;
import org.junit.Before;
import org.junit.Test;

import static com.withblacks.business.entities.GENDER.MALE;
import static com.withblacks.business.layers.user.UserMockHelper.mockUser;
import static com.withblacks.business.layers.user.UserMockHelper.mockUserDto;
import static com.withblacks.rest.user.utils.MatcherUtils.dtoHasProperties;
import static com.withblacks.rest.user.utils.MatcherUtils.hasProperties;
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
        assertThat(Iterables.getLast(mapper.convertToDtos(users)), dtoHasProperties("Iron", "Man", MALE));
    }
}