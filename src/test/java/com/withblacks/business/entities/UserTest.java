package com.withblacks.business.entities;

import org.junit.Before;
import org.junit.Test;

import static com.withblacks.business.builder.UserBuilder.build;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;

public class UserTest {

    private User user;

    @Before
    public void setUp() throws Exception {
        user = build("FirstName", "LastName", GENDER.FEMALE);
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
    public void testEquals() throws Exception {
        assertThat(user, is(user));
    }
}
