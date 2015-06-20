package com.withblacks.facade.user;

import com.withblacks.business.entity.User;
import com.withblacks.business.layers.UserLayer;
import com.withblacks.rest.user.dto.UserResource;
import com.withblacks.rest.user.dto.mapper.UserMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserFacadeLayerImpl implements UserFacadeLayer {

    private final transient UserLayer userLayer;
    private final UserMapperImpl mapper;

    @Autowired
    public UserFacadeLayerImpl(final UserLayer userLayer, final UserMapperImpl mapper) {
        this.userLayer = userLayer;
        this.mapper = mapper;
    }

    @Override
    public UserResource getUser(final String userName) throws NoSuchElementException {
        return mapper.convertTo(userLayer.find(userName));
    }

    @Override
    public Iterable<UserResource> getUsers() {
        return mapper.convertTo(userLayer.findAll());
    }

    @Override
    public UserResource getUser(final Long id) throws NoSuchElementException {
        return mapper.convertTo(userLayer.find(id));
    }

    @Override
    public UserResource create(final UserResource resource) throws IllegalArgumentException, NullPointerException, ClassCastException {
        User user2 = mapper.convertFrom(resource);
        User user1 = userLayer.create(user2);
        return mapper.convertTo(user1);
    }

    @Override
    public boolean update(final Long id, final UserResource resource) throws NoSuchElementException, ClassCastException, IllegalArgumentException {
        return userLayer.update(id, mapper.convertFrom(resource));
    }

    @Override
    public void remove(final Long id) throws NoSuchElementException, UnsupportedOperationException, ClassCastException {
        userLayer.delete(id);
    }
}
