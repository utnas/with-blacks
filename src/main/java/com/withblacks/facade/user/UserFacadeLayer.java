package com.withblacks.facade.user;

import com.withblacks.business.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public interface UserFacadeLayer {

    User getUser(final String userName);

    List<User> getUsers();

    User getUser(final Long id) throws NoSuchElementException;

    User create(final User user) throws NoSuchElementException;

    boolean update(final User user) throws NoSuchElementException, ClassCastException, IllegalArgumentException;

    void remove(final Long id) throws NoSuchElementException;
}
