package com.withblacks.business.entity;

import com.github.javafaker.Faker;
import com.withblacks.business.builder.UserBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;

public class UserTest {

    User user;

    @Before
    public void setUp() throws Exception {
        final Faker faker = new Faker();
        user = UserBuilder.build(2, "FirstName", "LastName", GENDER.FEMALE);
    }

    @Test
    public void testGetFirstName() throws Exception {
        assertThat(user.getFirstName(), is("FirstName"));
    }

    @Test
    public void testGetLastName() throws Exception {
        assertThat(user.getLastName(), is("LastName"));
    }

    @Test
    public void testGetGender() throws Exception {
        assertThat(user.getGender().toString(), is("FEMALE"));
    }

    @Test
    public void testGetId() throws Exception {
        assertThat(user.getId(), is(2L));
    }

    @Test
    public void testEquals() throws Exception {
        assertThat(user, is(user));
    }
}