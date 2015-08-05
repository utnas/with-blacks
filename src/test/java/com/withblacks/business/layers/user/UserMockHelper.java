package com.withblacks.business.layers.user;

import com.withblacks.business.entities.GENDER;
import com.withblacks.business.entities.User;
import com.withblacks.facade.user.UserMapper;
import com.withblacks.rest.user.dto.UserDto;

import static java.util.Arrays.asList;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class UserMockHelper {

    public static User mockUser(final String firstName, final String lastName, final GENDER gender) {
        final User user = mock(User.class);

        when(user.getFirstName()).thenReturn(firstName);
        when(user.getLastName()).thenReturn(lastName);
        when(user.getGender()).thenReturn(gender);

        return user;
    }

    public static UserDto mockUserDto(final String firstName, final String lastName, final GENDER gender) {
        final UserDto dto = mock(UserDto.class);

        doReturn(firstName).when(dto).getFirstName();
        doReturn(lastName).when(dto).getLastName();
        doReturn(gender).when(dto).getGender();

        return dto;
    }

    public static UserMapper mockUserMapper(final UserDto dto, final User user) {
        final UserMapper mapper = mock(UserMapper.class);

        when(mapper.convertToDto(any(User.class))).thenReturn(dto);
        when(mapper.convertToUser(any(UserDto.class))).thenReturn(user);
        when(mapper.convertToDtos(anyList())).thenReturn(asList(dto));

        return mapper;
    }
}
