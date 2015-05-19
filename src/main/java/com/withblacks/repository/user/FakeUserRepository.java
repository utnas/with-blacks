package com.withblacks.repository.user;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.withblacks.business.User;
import com.withblacks.repository.data.FakeData;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FakeUserRepository implements IUserRepositoryLayer {

    private FakeData fakeData;

    public FakeUserRepository() {
        fakeData = new FakeData();
    }

    @Override
    public User find(final String userName) {
        try {
            return Iterables.find(fakeData.getUsers(), new Predicate<User>() {
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
            return Iterables.find(fakeData.getUsers(), new Predicate<User>() {
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
        return fakeData.getUsers();
    }

    @Override
    public boolean create(final User user) {
        return fakeData.addUser(user);
    }

    @Override
    public boolean update(final User user) {
        final User fakeDataUser = fakeData.findUser(user);
        fakeData.getUsers().remove(fakeDataUser);
        return fakeData.addUser(
                new User(fakeDataUser.getFirstName(), fakeDataUser.getLastName(), fakeDataUser.getGender())
        );
    }

    @Override
    public void delete(final long id) {
        // Do delete
    }
}