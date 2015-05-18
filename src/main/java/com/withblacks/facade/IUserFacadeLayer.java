package com.withblacks.facade;

import com.withblacks.rest.UserDto;

public interface IUserFacadeLayer {

    UserDto getUser(final String userName);

    Iterable<UserDto> getUsers();

    UserDto getUser(final long id);

    UserDto create(final UserDto userDto);

    UserDto update(final UserDto userDto);

    void remove(final long id);
}
