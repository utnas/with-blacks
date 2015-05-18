package com.withblacks.repository;

import com.withblacks.business.User;
import com.withblacks.rest.UserDto;

import java.util.List;

public interface IUserRepositoryLayer {

    User find(final String userName);

    List<User> findAll();

    User find(final long id);

    User create(final UserDto userDto);

    User update(final UserDto userDto);

    void delete(final long id);
}
