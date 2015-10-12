package com.withblacks.business.layers.user;

import com.withblacks.business.entities.user.User;
import com.withblacks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
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
    public List<User> findAll() {
        return newArrayList(repository.findAll());
    }

    @Override
    public User find(final Long id) throws NoSuchElementException {
        return repository.findOne(id);
    }

    @Override
    public User create(final User entity) throws IllegalArgumentException, NullPointerException, ClassCastException {
        return repository.save(entity);
    }

    @Override
    public User update(final Long id, final User entity) throws NoSuchElementException, ClassCastException, IllegalArgumentException {
        return repository.save(entity);
    }

    @Override
    public void delete(final Long id) throws NoSuchElementException, UnsupportedOperationException, ClassCastException {
        repository.delete(id);
    }
}
