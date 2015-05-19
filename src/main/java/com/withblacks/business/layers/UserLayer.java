package com.withblacks.business.layers;

import com.withblacks.business.User;
import com.withblacks.repository.user.IUserRepositoryLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLayer implements IUserLayer {

    private IUserRepositoryLayer repository;

    public UserLayer() {
    }

    @Autowired
    public UserLayer(final IUserRepositoryLayer repository) {
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

    public boolean create(final User user) {
        return repository.create(user);
    }

    public boolean update(final User user) {
        return repository.update(user);
    }

    public void delete(final long id) {
        // Do delete
    }
}
