package com.withblacks.business.layers;

import com.withblacks.business.User;

import java.util.List;

public interface IUserLayer {

    User find(final String userName);

    List<User> findAll();

    User find(final long id);

    boolean create(final User user);

    boolean update(final User user);

    void delete(final long id);
}