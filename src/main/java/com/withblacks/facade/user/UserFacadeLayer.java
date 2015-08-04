package com.withblacks.facade.user;

import com.withblacks.business.entities.User;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public interface UserFacadeLayer {

    User getUser(final String userName);

    Iterable<User> getUsers();

    User getUser(final Long id) throws NoSuchElementException;

    Iterable<User> create(final User user) throws NoSuchElementException;

    Iterable<User> update(final Long id, final User user) throws NoSuchElementException, ClassCastException, IllegalArgumentException;

    void remove(final Long id) throws NoSuchElementException;
}
