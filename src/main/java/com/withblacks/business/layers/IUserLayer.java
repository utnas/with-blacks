package com.withblacks.business.layers;

import com.withblacks.business.User;

import java.util.List;

public interface IUserLayer {

    User find(final String userName);

    List<User> findAll();

    User find(final long id);

    boolean create(final User userDto);

    User update(final User userDto);

    void delete(final long id);
}