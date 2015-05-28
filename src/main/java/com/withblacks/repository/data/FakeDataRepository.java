package com.withblacks.repository.data;

import com.github.javafaker.Faker;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.withblacks.business.entity.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static com.google.common.collect.Lists.newArrayList;
import static com.withblacks.business.builder.UserBuilder.build;
import static com.withblacks.business.entity.GENDER.MALE;

@Component
public class FakeDataRepository {

    private final AtomicLong idCounter = new AtomicLong(0);
    private final Faker faker = new Faker();
    private final List<User> repository = newArrayList();

    public FakeDataRepository() {
    }

    public List<User> getUsers() {
        repository.addAll(generateUsers());
        return repository;
    }

    private Collection<User> generateUsers() {
        final Collection<User> result = newArrayList();
        for (int i = 0; i < 20; i++) {
            result.add(build(idCounter.getAndIncrement(), faker.name().firstName(), faker.name().lastName(), MALE));
        }
        return result;
    }

    public boolean addUser(final User user) {
        return repository.add(user);
    }

    public User findUser(final User user) {
        return Iterables.find(repository, new Predicate<User>() {
            @Override
            public boolean apply(User input) {
                return user.getFirstName().equals(input.getFirstName())
                        && user.getLastName().equals(input.getLastName())
                        && user.getGender().equals(input.getGender());
            }
        });
    }

    public void remove(final User fakeUser) {
        Collections2.filter(repository, new Predicate<User>() {
            @Override
            public boolean apply(User input) {
                return repository.contains(input);
            }
        });
    }
}