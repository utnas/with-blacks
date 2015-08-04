package com.withblacks.facade.user;

import com.withblacks.business.entities.User;
import com.withblacks.rest.user.UserMapper;
import com.withblacks.rest.user.dto.UserDto;
import org.junit.Test;

import static com.withblacks.business.entities.GENDER.MALE;
import static com.withblacks.rest.user.utils.MatcherUtils.hasProperties;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserMapperTest {

    @Test
    public void itShouldConvertToUser() {
        final UserMapper mapper = new UserMapper();
        final UserDto dto = new UserDto();

        dto.setFirstName("Iron");
        dto.setLastName("Man");
        dto.setGender(MALE);

        final User user = mapper.convertToUser(dto);

        assertThat(user, hasProperties("Iron", "Man", MALE));
    }
}