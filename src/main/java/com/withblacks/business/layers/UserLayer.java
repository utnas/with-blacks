package com.withblacks.business.layers;

import com.withblacks.business.entity.User;

import java.util.List;
import java.util.NoSuchElementException;

public interface UserLayer {

    User find(final String userName);

    List<User> findAll();

    User find(final long id);

    User create(final User user) throws NoSuchElementException;

    boolean update(final User user);

    void delete(final long id) throws NoSuchElementException;
}