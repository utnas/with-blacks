package com.withblacks.rest.user.dto;

import com.withblacks.business.entity.GENDER;
import com.withblacks.facade.user.mapper.UserResourceBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserResourceTest {

    private UserResource resource;

    @Before
    public void setUp() throws Exception {
        resource = UserResourceBuilder.build(1L, "FirstName", "LastName", GENDER.FEMALE);
    }

    @Test
    public void testGetFirstName() throws Exception {
        assertThat(resource.getFirstName(), is("FirstName"));
    }

    @Test
    public void testSetFirstName() throws Exception {
        resource.setFirstName("New FirstName");
        assertThat(resource.getFirstName(), is("New FirstName"));
    }

    @Test
    public void testGetLastName() throws Exception {
        assertThat(resource.getLastName(), is("LastName"));
    }

    @Test
    public void testSetLastName() throws Exception {
        resource.setLastName("New LastName");
        assertThat(resource.getLastName(), is("New LastName"));
    }

    @Test
    public void testGetGender() throws Exception {
        assertThat(resource.getGender().toString(), is("FEMALE"));
    }

    @Test
    public void testSetGender() throws Exception {
        resource.setGender(GENDER.MALE);
        assertThat(resource.getGender().toString(), is("MALE"));
    }

    @Test
    public void testGetIds() throws Exception {
        assertThat(resource.getIds(), is(1L));
    }
}