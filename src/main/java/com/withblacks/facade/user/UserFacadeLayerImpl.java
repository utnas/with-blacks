package com.withblacks.facade.user;

import com.withblacks.business.entities.User;
import com.withblacks.business.layers.user.UserLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserFacadeLayerImpl implements UserFacadeLayer {

    private UserLayer<User> layer;

    public UserFacadeLayerImpl() {
    }

    @Autowired
    public UserFacadeLayerImpl(final UserLayer<User> layer) {
        this.layer = layer;
    }

    @Override
    public User getUser(final String userName) throws NoSuchElementException {
        return layer.find(userName);
    }

    @Override
    public Iterable<User> getUsers() {
        return layer.findAll();
    }

    @Override
    public User getUser(final Long id) throws NoSuchElementException {
        return layer.find(id);
    }

    @Override
    public Iterable<User> create(final User user) throws IllegalArgumentException, NullPointerException, ClassCastException {
        return layer.create(user);
    }

    @Override
    public Iterable<User> update(final Long id, final User user) throws NoSuchElementException, ClassCastException, IllegalArgumentException {
        return layer.update(id, user);
    }

    @Override
    public void remove(final Long id) throws NoSuchElementException, UnsupportedOperationException, ClassCastException {
        layer.delete(id);
    }
}
