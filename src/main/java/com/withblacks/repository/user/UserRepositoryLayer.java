package com.withblacks.repository.user;

import com.withblacks.business.entity.User;

import java.util.List;
import java.util.NoSuchElementException;

public interface UserRepositoryLayer {

    User find(final String userName) throws NoSuchElementException;

    List<User> findAll();

    User find(final long id) throws NoSuchElementException;

    User save(final User user) throws NoSuchElementException;

    boolean modify(final User user) throws NoSuchElementException, ClassCastException, IllegalArgumentException;

    void delete(final long id) throws NoSuchElementException, UnsupportedOperationException, ClassCastException;
}