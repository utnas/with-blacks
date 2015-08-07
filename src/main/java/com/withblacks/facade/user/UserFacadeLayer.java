package com.withblacks.facade.user;

import com.withblacks.facade.user.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public interface UserFacadeLayer {

    UserDto getUser(final String userName);

    Iterable<UserDto> getUsers();

    UserDto getUser(final Long id) throws NoSuchElementException;

    UserDto create(final UserDto dto) throws NoSuchElementException;

    UserDto update(final Long id, final UserDto dto) throws NoSuchElementException, ClassCastException, IllegalArgumentException;

    void remove(final Long id) throws NoSuchElementException;
}
