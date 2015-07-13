package com.withblacks.business.layers;

import com.withblacks.business.entity.User;
import com.withblacks.repository.user.UserRepositoryLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public final class UserLayerImpl implements UserLayer<User> {

    private final transient UserRepositoryLayer repository;

    @Autowired
    public UserLayerImpl(final UserRepositoryLayer repository) {
        this.repository = repository;
    }

    public User find(final String userName) throws NoSuchElementException {
        return repository.find(userName);
    }

    public Iterable<User> findAll() {
        return repository.findAll();
    }

    public User find(final long id)throws NoSuchElementException {
        return repository.find(id);
    }

    public User create(final User user) throws IllegalArgumentException, NullPointerException, ClassCastException  {
        return repository.save(user);
    }

    public boolean update(final Long id, final User user) throws NoSuchElementException, ClassCastException, IllegalArgumentException {
        return repository.modify(id,user);
    }

    public boolean delete(final Long id) throws NoSuchElementException, UnsupportedOperationException, ClassCastException {
        return repository.delete(id);
    }
}