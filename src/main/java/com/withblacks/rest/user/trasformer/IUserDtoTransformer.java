package com.withblacks.rest.user.trasformer;

import com.withblacks.business.User;
import com.withblacks.rest.user.UserDto;

import java.util.List;

public interface IUserDtoTransformer {

    Iterable<UserDto> transform(final List<User> users);

    UserDto transform(final User users);

    User transform(final UserDto userDto);
}
