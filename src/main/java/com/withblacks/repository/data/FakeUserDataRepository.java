package com.withblacks.repository.data;

import com.google.common.base.Predicate;
import com.google.common.base.Throwables;
import com.google.common.collect.Iterables;
import com.withblacks.business.entity.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.NoSuchElementException;

import static com.google.common.collect.Lists.newArrayList;
import static com.withblacks.repository.data.UserGenerator.generateUsers;

@Component
public class FakeUserDataRepository {

    private Collection<User> repository = newArrayList();

    public FakeUserDataRepository() {
        repository.addAll(generateUsers(20));
    }

    public Iterable<User> getUsers() {
        return repository;
    }

    public boolean addUser(final User user) throws IllegalArgumentException, NullPointerException, ClassCastException {
        if (repository.contains(user)) {
            throw Throwables.propagate(new IllegalArgumentException());
        }
        return repository.add(user);
    }

    public User findUser(final User user) throws NoSuchElementException {
        return getUser(user);
    }

    public boolean remove(final User fakeUser) throws NullPointerException, UnsupportedOperationException, ClassCastException {
        return repository.remove(fakeUser);
    }

    private User getUser(final User user) throws NoSuchElementException {
        return Iterables.find(repository, new Predicate<User>() {
            public boolean apply(User input) {
                return user.getId().equals(input.getId()) ||
                        user.getFirstName().equals(input.getFirstName()) &&
                                user.getLastName().equals(input.getLastName()) &&
                                user.getGender().equals(input.getGender());
            }
        });
    }
}