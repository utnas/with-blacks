package com.withblacks.facade.user;

import com.withblacks.business.entity.User;
import com.withblacks.business.layers.UserLayer;
import com.withblacks.rest.user.dto.UserResource;
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
    public UserResource getUser(final String userName) throws NoSuchElementException {
        return null;
    }

    @Override
    public Iterable<UserResource> getUsers() {
        return null;
    }

    @Override
    public UserResource getUser(final Long id) throws NoSuchElementException {
        return null;
    }

    @Override
    public UserResource create(final UserResource resource) throws IllegalArgumentException, NullPointerException, ClassCastException {
        return null;
    }

    @Override
    public boolean update(final Long id, final UserResource resource) throws NoSuchElementException, ClassCastException, IllegalArgumentException {
        return false;
    }

    @Override
    public void remove(final Long id) throws NoSuchElementException, UnsupportedOperationException, ClassCastException {
        userLayer.delete(id);
    }
}
