package com.withblacks.business.layers.user;

import com.withblacks.business.entities.User;
import com.withblacks.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

import static com.google.common.collect.Lists.newArrayList;

@Component
public class UserLayerImpl implements UserLayer<User> {

    private UserRepository repository;

    public UserLayerImpl(){
    }

    @Autowired
    public UserLayerImpl(final UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User find(final String entityName) throws NoSuchElementException {
        return repository.findByLastName(entityName);
    }

    @Override
    public Iterable<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User find(final Long id) throws NoSuchElementException {
        return repository.findOne(id);
    }

    @Override
    public Iterable<User> create(final User entity) throws IllegalArgumentException, NullPointerException, ClassCastException {
        final Iterable<User> list = newArrayList(entity);
        return repository.save(list);
    }

    @Override
    public Iterable<User> update(final Long id, final User entity) throws NoSuchElementException, ClassCastException, IllegalArgumentException {
        return repository.save(newArrayList(entity));
    }

    @Override
    public void delete(Long id) throws NoSuchElementException, UnsupportedOperationException, ClassCastException {
        repository.delete(id);
    }
}
