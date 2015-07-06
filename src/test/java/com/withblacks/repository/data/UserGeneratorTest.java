package com.withblacks.repository.data;

import org.junit.Test;

import static com.google.common.collect.Iterables.isEmpty;
import static com.withblacks.repository.data.UserGenerator.generateUsers;
import static com.withblacks.repository.data.UserGenerator.generateUsersResource;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserGeneratorTest {

    @Test
    public void testGenerateUsers() throws Exception {
        assertThat(generateUsers(3).size(), is(3));
    }

    @Test
    public void testItShouldReturnEmptyList() throws Exception {
        assertThat(isEmpty(generateUsers(0)), is(true));
    }

    @Test
    public void testGenerateUsersResource() {
        assertThat(generateUsersResource(2).size(), is(2));
    }

    @Test
    public void testGenerateUsersResourceShouldReturnEmptyList() {
        assertThat(isEmpty(generateUsersResource(0)), is(true));
    }
}