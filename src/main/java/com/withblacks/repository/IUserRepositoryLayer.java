package com.withblacks.repository;

import com.withblacks.rest.UserDto;

public interface IUserRepositoryLayer {

    UserDto find(final String userName);

    Iterable<UserDto> findAll();

    UserDto find(final long id);

    UserDto create(final UserDto userDto);

    UserDto update(final UserDto userDto);

    void delete(final long id);
}
