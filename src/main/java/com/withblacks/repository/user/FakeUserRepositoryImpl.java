package com.withblacks.repository.user;

import com.google.common.base.Predicate;
import com.google.common.base.Throwables;
import com.google.common.collect.Iterables;
import com.withblacks.business.entity.User;
import com.withblacks.repository.data.FakeDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FakeUserRepositoryImpl implements UserRepositoryLayer {

    private FakeDataRepository repository;

    public FakeUserRepositoryImpl() {
    }

    @Autowired
    public FakeUserRepositoryImpl(FakeDataRepository repository) {
        this.repository = repository;
    }

    @Override
    public User find(final String userName) throws NoSuchElementException {
        return Iterables.find(repository.getUsers(), new Predicate<User>() {
            @Override
            public boolean apply(User input) {
                return input.getFirstName().equals(userName) ||
                        input.getLastName().equals(userName);
            }
        });
    }

    @Override
    public User find(final long id) throws NoSuchElementException {
        return Iterables.find(repository.getUsers(), new Predicate<User>() {
            @Override
            public boolean apply(User input) {
                return input.getId() == id;
            }
        });
    }

    @Override
    public List<User> findAll() {
        return repository.getUsers();
    }

    @Override
    public User save(final User user) throws NoSuchElementException {
        if (repository.addUser(user)) {
            return user;
        }
        throw Throwables.propagate(new NoSuchElementException());
    }

    @Override
    public boolean modify(final User user) {
        final User fakeUser = repository.findUser(user);
        repository.remove(fakeUser);
        return repository.addUser(user);
    }

    @Override
    public void delete(final long id) throws NoSuchElementException {
        repository.remove(find(id));
    }
}