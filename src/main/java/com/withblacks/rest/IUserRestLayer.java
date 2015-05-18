package com.withblacks.rest;

import com.withblacks.business.GENDER;

interface IUserRestLayer {

    Iterable<UserDto> findAll();

    UserDto findByName(final String name);

    UserDto findById(final long id);

    UserDto create(final String firstName, final String lastName, final GENDER gender);

    UserDto update(final String firstName, final String lastName, final GENDER gender);

    void delete(final long id);
}
