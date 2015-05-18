package com.withblacks.repository.data;

import com.github.javafaker.Faker;
import com.withblacks.business.User;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static com.google.common.collect.Lists.newArrayList;
import static com.withblacks.business.GENDER.MALE;

public class FakeData {

    private AtomicLong idCounter = new AtomicLong(0);
    private Faker faker = new Faker();

    public FakeData() {
    }

    public List<User> getUsers() {
        return newArrayList(generateUsers());
    }

    private Collection<User> generateUsers() {
        Collection<User> result = newArrayList();
        for (int i = 0; i < 20; i++) {
            result.add(new User(idCounter.getAndIncrement(), faker.name().firstName(), faker.name().lastName(), MALE));
        }
        return result;
    }
}