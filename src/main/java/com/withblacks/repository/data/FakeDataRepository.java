package com.withblacks.repository.data;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.withblacks.business.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

import static com.google.common.collect.Lists.newArrayList;
import static com.withblacks.repository.data.UserGenerator.generateUsers;

@Component
public class FakeDataRepository {

    private List<User> repository = newArrayList();

    public FakeDataRepository() {
        repository.addAll(generateUsers(20));
    }

    public List<User> getUsers() {
        return repository;
    }

    public boolean addUser(final User user) {
        return !repository.contains(user) && repository.add(user);
    }

    public User findUser(final User user) throws NoSuchElementException {
        return getUser(user);
    }

    public void remove(final User fakeUser) {
        try {
            repository.remove(fakeUser);
        } catch (UnsupportedOperationException e) {
            throw e;
        } catch (NullPointerException e) {
            throw e;
        } catch (ClassCastException e) {
            throw e;
        }
    }

    private User getUser(final User user) throws NoSuchElementException {
        return Iterables.find(repository, new Predicate<User>() {
            public boolean apply(User input) {
                return user.getId() == input.getId() ||
                        user.getFirstName().equals(input.getFirstName()) &&
                                user.getLastName().equals(input.getLastName()) &&
                                user.getGender().equals(input.getGender());
            }
        });
    }
}