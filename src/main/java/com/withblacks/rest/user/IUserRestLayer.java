package com.withblacks.rest.user;

import com.withblacks.business.entity.GENDER;

interface IUserRestLayer {

    Iterable<UserDto> findAll();

    UserDto findByName(final String name);

    UserDto findById(final long id);

    boolean create(final String firstName, final String lastName, final GENDER gender);

    boolean update(final String firstName, final String lastName, final GENDER gender);

    void delete(final long id);
}
