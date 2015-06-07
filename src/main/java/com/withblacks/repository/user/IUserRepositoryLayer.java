package com.withblacks.repository.user;

import com.withblacks.business.entity.User;

import java.util.List;

public interface IUserRepositoryLayer {

    User find(final String userName);

    List<User> findAll();

    User find(final long id);

    User save(final User user);

    boolean modify(final User user);

    void delete(final long id);
}
