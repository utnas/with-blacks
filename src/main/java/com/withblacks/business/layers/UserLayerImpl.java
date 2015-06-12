package com.withblacks.business.layers;

import com.withblacks.business.entity.User;
import com.withblacks.repository.user.UserRepositoryLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserLayerImpl implements UserLayer {

    private UserRepositoryLayer repository;

    public UserLayerImpl() {
    }

    @Autowired
    public UserLayerImpl(final UserRepositoryLayer repository) {
        this.repository = repository;
    }

    public User find(final String userName) {
        return repository.find(userName);
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User find(final long id) {
        return repository.find(id);
    }

    public User create(final User user) throws NoSuchElementException {
        return repository.save(user);
    }

    public boolean update(final User user) {
        return repository.modify(user);
    }

    public void delete(final long id) throws NoSuchElementException{
        repository.delete(id);
    }
}
