package com.withblacks.repository.data;

import com.withblacks.business.entity.User;
import org.junit.Test;

import java.util.NoSuchElementException;

import static com.google.common.collect.Iterables.size;
import static com.withblacks.business.builder.UserBuilder.build;
import static com.withblacks.business.entity.GENDER.FEMALE;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class FakeUserDataRepositoryTest {

    @Test
    public void testGetUsers() throws Exception {
        final FakeUserDataRepository repository = getFakeDataRepository();
        assertThat(size(repository.getUsers()), is(20));
    }

    @Test
    public void testAddUser() throws Exception {
        final FakeUserDataRepository repository = getFakeDataRepository();
        repository.addUser(build("first", "last", FEMALE));
        assertThat(size(repository.getUsers()), is(21));
    }

    @Test
    public void testFindUser() throws Exception {
        final FakeUserDataRepository repository = getFakeDataRepository();
        final User user = build("first", "last", FEMALE);
        repository.addUser(user);
        assertThat(repository.findUser(user), is(user));
    }

    @Test
    public void testRemove() throws Exception {
        final FakeUserDataRepository repository = getFakeDataRepository();
        final User user = build("first", "last", FEMALE);
        repository.addUser(user);
        repository.remove(user);
        try {
            repository.findUser(user);
            fail();
        } catch (NoSuchElementException e) {
            assertThat(e.toString(), is("java.util.NoSuchElementException"));
        }
    }

    private static FakeUserDataRepository getFakeDataRepository() {
        return new FakeUserDataRepository();
    }
}