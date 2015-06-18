package com.withblacks.repository.user;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.withblacks.business.entity.User;
import com.withblacks.repository.data.FakeDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

import static com.google.common.base.Throwables.propagate;

@Service
public class FakeUserRepositoryImpl implements UserRepositoryLayer {

    private final transient FakeDataRepository repository;

    @Autowired
    public FakeUserRepositoryImpl(final FakeDataRepository repository) {
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
    public User save(final User user) throws IllegalArgumentException, NullPointerException, ClassCastException  {
        if (repository.addUser(user)) {
            return user;
        }
        throw propagate(new NoSuchElementException());
    }

    @Override
    public boolean modify(final User user) throws NoSuchElementException, ClassCastException, IllegalArgumentException {
        try {
        final User fakeUser = repository.findUser(user);
        repository.remove(fakeUser);
        return repository.addUser(user);
        } catch (NoSuchElementException e) {
            throw propagate(new NoSuchElementException());
        } catch (ClassCastException e) {
            throw propagate(new ClassCastException());
        } catch (IllegalArgumentException e) {
            throw propagate(new IllegalArgumentException());
        }
    }

    @Override
    public void delete(final long id) throws NoSuchElementException, UnsupportedOperationException, ClassCastException {
        repository.remove(find(id));
    }
}