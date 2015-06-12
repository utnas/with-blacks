package com.withblacks.repository.user;

import com.withblacks.business.entity.User;

import java.util.List;
import java.util.NoSuchElementException;

public interface UserRepositoryLayer {

    User find(final String userName);

    List<User> findAll();

    User find(final long id);

    User save(final User user) throws NoSuchElementException;

    boolean modify(final User user);

    void delete(final long id);
}
