package com.withblacks.business.layers;

import com.withblacks.business.entity.User;

import java.util.List;
import java.util.NoSuchElementException;

public interface UserLayer {

    User find(final String userName) throws NoSuchElementException;

    List<User> findAll();

    User find(final long id) throws NoSuchElementException;

    User create(final User user) throws IllegalArgumentException, NullPointerException, ClassCastException ;

    boolean update(final Long id,final User user) throws NoSuchElementException, ClassCastException, IllegalArgumentException;

    void delete(final Long id) throws NoSuchElementException, UnsupportedOperationException, ClassCastException;
}