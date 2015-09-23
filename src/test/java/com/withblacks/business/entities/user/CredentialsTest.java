package com.withblacks.business.entities.user;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CredentialsTest {

    private Credentials credentials;

    @Before
    public void setUp() throws Exception {
        credentials = new Credentials("Login", "Password");
    }

    @Test
    public void itShouldSetLogin() {
        credentials.setLogin("NewLogin");
        assertThat(credentials.getLogin(), is("NewLogin"));
    }

    @Test
    public void itShouldSetPassword() {
        credentials.setLogin("NewPassword");
        assertThat(credentials.getLogin(), is("NewPassword"));
    }
}