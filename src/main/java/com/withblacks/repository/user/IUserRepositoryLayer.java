package com.withblacks.repository.user;

import com.withblacks.business.entity.User;

import java.util.List;

public interface IUserRepositoryLayer {

    User find(final String userName);

    List<User> findAll();

    User find(final long id);

    boolean create(final User user);

    boolean update(final User user);

    void delete(final long id);
}
