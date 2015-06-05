package com.withblacks.repository.user;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.withblacks.business.entity.User;
import com.withblacks.repository.data.FakeDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

import static com.withblacks.business.builder.UserBuilder.build;

@Service
public class FakeUserRepository implements IUserRepositoryLayer {

    private FakeDataRepository repository;

    public FakeUserRepository() {
    }

    @Autowired
    public FakeUserRepository( FakeDataRepository repository) {
        this.repository = repository;
    }

    @Override
    public User find(final String userName) {
        try {
            return Iterables.find(repository.getUsers(), new Predicate<User>() {
                @Override
                public boolean apply(User input) {
                    return input.getFirstName().equals(userName) ||
                            input.getLastName().equals(userName);
                }
            });
        } catch (NoSuchElementException e) {
            return new User();
        }
    }

    @Override
    public User find(final long id) {
        try {
            return Iterables.find(repository.getUsers(), new Predicate<User>() {
                @Override
                public boolean apply(User input) {
                    return input.getId() == id;
                }
            });
        } catch (NoSuchElementException e) {
            return new User();
        }
    }

    @Override
    public List<User> findAll() {
        return repository.getUsers();
    }

    @Override
    public User save(final User user) {
        try {
            boolean result = repository.addUser(user);
            if (result)
                return user;
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    @Override
    public boolean update(final User user) {
        final User fakeUser = repository.findUser(user);
        repository.remove(fakeUser);
        return repository.addUser(
                build(fakeUser.getId(), fakeUser.getFirstName(), fakeUser.getLastName(), fakeUser.getGender())
        );
    }

    @Override
    public void delete(final long id) {
        // Do delete
    }
}