package com.withblacks.business.entities.user;

import com.withblacks.business.entities.user.GENDER;
import com.withblacks.business.entities.user.User;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static com.withblacks.business.entities.user.UserBuilder.build;
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
