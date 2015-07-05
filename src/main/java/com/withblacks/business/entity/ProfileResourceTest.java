package com.withblacks.business.entity;

import com.withblacks.business.entity.ProfileResource;
import com.withblacks.rest.profile.dto.mapper.ProfileResourceBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfileResourceTest {
    private ProfileResource profileResource;

    @Before
    public void setUp() throws Exception {
        profileResource = ProfileResourceBuilder.build("large", "En", "content of the profile");
    }

    @Test
    public void testGetName() throws Exception {
        assertThat("large", is(profileResource.getName()));
    }

    @Test
    public void testGetLanguage() throws Exception {
        assertThat("En", is(profileResource.getLanguage()));
    }

    @Test
    public void testGetDescription() throws Exception {
        assertThat("content of the profile", is(profileResource.getDescription()));
    }
}