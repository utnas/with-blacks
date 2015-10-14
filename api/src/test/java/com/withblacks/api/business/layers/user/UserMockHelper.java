package com.withblacks.api.business.layers.user;

import com.withblacks.api.business.entities.user.GENDER;
import com.withblacks.api.business.entities.user.User;
import com.withblacks.api.facade.user.dto.UserDto;
import com.withblacks.api.facade.user.dto.UserMapper;

import static java.util.Collections.singletonList;
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
        when(mapper.convertToDtos(anyList())).thenReturn(singletonList(dto));

        return mapper;
    }
}
