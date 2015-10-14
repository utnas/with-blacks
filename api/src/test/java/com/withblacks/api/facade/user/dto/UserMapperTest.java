package com.withblacks.api.facade.user.dto;

import com.withblacks.api.business.entities.user.GENDER;
import com.withblacks.api.business.entities.user.User;
import com.withblacks.api.facade.project.dto.ProjectMapper;
import org.junit.Before;
import org.junit.Test;

import static com.google.common.collect.Iterables.getLast;
import static com.withblacks.api.business.layers.user.UserMockHelper.mockUser;
import static com.withblacks.api.business.layers.user.UserMockHelper.mockUserDto;
import static com.withblacks.api.rest.utils.MatcherUtils.dtoHasProperties;
import static com.withblacks.api.rest.utils.MatcherUtils.hasProperties;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertThat;

public class UserMapperTest {

    private UserMapper mapper;

    @Before
    public void setUp() {
        mapper = new UserMapper( new ProjectMapper());
    }

    @Test
    public void testConvertToUser() throws Exception {
        final UserDto dto = mockUserDto("Iron", "Man", GENDER.MALE);
        assertThat(mapper.convertToUser(dto), hasProperties("Iron", "Man", GENDER.MALE));
    }

    @Test
    public void testConvertToDto() throws Exception {
        final User user = mockUser("Iron", "Man", GENDER.MALE);
        assertThat(mapper.convertToDto(user), dtoHasProperties("Iron", "Man", GENDER.MALE));
    }

    @Test
    public void testConvertToDtos() throws Exception {
        final Iterable<User> users = singletonList(mockUser("Iron", "Man", GENDER.MALE));
        assertThat(getLast(mapper.convertToDtos(users)), dtoHasProperties("Iron", "Man", GENDER.MALE));
    }
}