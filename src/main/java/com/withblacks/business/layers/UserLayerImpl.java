package com.withblacks.business.layers;

import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class UserLayerImpl<User> implements UserLayer<User> {

    public UserLayerImpl(){
    }

    @Override
    public User find(String entityName) throws NoSuchElementException {
        return null;
    }

    @Override
    public Iterable<User> findAll() {
        return null;
    }

    @Override
    public User find(Long id) throws NoSuchElementException {
        return null;
    }

    @Override
    public User create(User entity) throws IllegalArgumentException, NullPointerException, ClassCastException {
        return null;
    }

    @Override
    public boolean update(Long id, User entity) throws NoSuchElementException, ClassCastException, IllegalArgumentException {
        return false;
    }

    @Override
    public void delete(Long id) throws NoSuchElementException, UnsupportedOperationException, ClassCastException {

    }
}
