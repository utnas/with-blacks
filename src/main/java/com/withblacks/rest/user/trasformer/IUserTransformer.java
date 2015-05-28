package com.withblacks.rest.user.trasformer;

import com.withblacks.business.entity.User;
import com.withblacks.rest.user.UserDto;

import java.util.List;

public interface IUserTransformer {

    Iterable<UserDto> toDtos(final List<User> users);

    UserDto toDto(final User users);

    User toUser(final UserDto userDto);
}
