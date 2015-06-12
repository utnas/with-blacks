package com.withblacks.repository.data;

import com.github.javafaker.Faker;
import com.withblacks.business.entity.User;
import com.withblacks.rest.user.dto.UserResource;
import com.withblacks.rest.user.dto.mapper.UserResourceBuilder;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static com.google.common.collect.Lists.newArrayList;
import static com.withblacks.business.builder.UserBuilder.build;
import static com.withblacks.business.entity.GENDER.MALE;

public class UserGenerator {

    public static List<User> generateUsers(final int size) {
        final Faker faker = new Faker();
        final AtomicLong idCounter = new AtomicLong(0);
        final List<User> result = newArrayList();

        for (int i = 0; i < size; i++) {
            result.add(build(idCounter.getAndIncrement(), faker.name().firstName(), faker.name().lastName(), MALE));
        }
        return result;
    }

    public static List<UserResource> generateUsersDto(final int size) {
        final Faker faker = new Faker();
        final AtomicLong idCounter = new AtomicLong(0);
        final List<UserResource> result = newArrayList();

        for (int i = 0; i < size; i++) {
            result.add(UserResourceBuilder.build(idCounter.getAndIncrement(), faker.name().firstName(), faker.name().lastName(), MALE));
        }
        return result;
    }
}
