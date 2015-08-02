package com.withblacks.facade.user;

import com.withblacks.rest.user.dto.UserDao;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public interface UserFacadeLayer {

    UserDao getUser(final String userName);

    Iterable<UserDao> getUsers();

    UserDao getUser(final Long id) throws NoSuchElementException;

    UserDao create(final UserDao userDao) throws NoSuchElementException;

    boolean update(final Long id, final UserDao userDao) throws NoSuchElementException, ClassCastException, IllegalArgumentException;

    void remove(final Long id) throws NoSuchElementException;
}
