package com.withblacks.repository.user;

import com.withblacks.business.entity.User;

import java.util.List;
import java.util.NoSuchElementException;

public interface UserRepositoryLayer {

    User find(final String userName) throws NoSuchElementException;

    List<User> findAll();

    User find(final Long id) throws NoSuchElementException;

    User save(final User user) throws IllegalArgumentException, NullPointerException, ClassCastException ;

    boolean modify(final Long id, final User user) throws NoSuchElementException, ClassCastException, IllegalArgumentException;

    void delete(final Long id) throws NoSuchElementException, UnsupportedOperationException, ClassCastException;
}