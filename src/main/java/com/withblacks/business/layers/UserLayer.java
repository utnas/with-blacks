package com.withblacks.business.layers;

import com.withblacks.business.entity.User;

import java.util.List;
import java.util.NoSuchElementException;

public interface UserLayer {

    User find(final String userName);

    List<User> findAll();

    User find(final long id) throws NoSuchElementException;

    User create(final User user) throws NoSuchElementException;

    boolean update(final User user) throws NoSuchElementException, ClassCastException, IllegalArgumentException;

    void delete(final long id) throws NoSuchElementException, UnsupportedOperationException, ClassCastException;
}