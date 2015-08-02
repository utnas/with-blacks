package com.withblacks.facade.user;

import com.withblacks.business.entity.User;
import com.withblacks.business.layers.UserLayer;
import com.withblacks.rest.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserFacadeLayerImpl implements UserFacadeLayer {

    private UserLayer<User> userLayer;

    public UserFacadeLayerImpl() {
    }

    @Autowired
    public UserFacadeLayerImpl(final UserLayer<User> userLayer) {
        this.userLayer = userLayer;
    }

    @Override
    public UserDao getUser(final String userName) throws NoSuchElementException {
        return null;
    }

    @Override
    public Iterable<UserDao> getUsers() {
        return null;
    }

    @Override
    public UserDao getUser(final Long id) throws NoSuchElementException {
        return null;
    }

    @Override
    public UserDao create(final UserDao resource) throws IllegalArgumentException, NullPointerException, ClassCastException {
        return null;
    }

    @Override
    public boolean update(final Long id, final UserDao resource) throws NoSuchElementException, ClassCastException, IllegalArgumentException {
        return false;
    }

    @Override
    public void remove(final Long id) throws NoSuchElementException, UnsupportedOperationException, ClassCastException {
        userLayer.delete(id);
    }
}
