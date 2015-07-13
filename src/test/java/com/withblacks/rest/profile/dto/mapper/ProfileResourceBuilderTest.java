package com.withblacks.rest.profile.dto.mapper;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class ProfileResourceBuilderTest {

    @Test
    public void testBuild() throws Exception {
        final ProfileResource build = ProfileResourceBuilder.build("Name", "Fr", "Description");
        assertThat(build, hasProperties("Name", "Fr", "Description"));
    }

    public static Matcher<ProfileResource> hasProperties(String name, String language, String content) {
        return new BaseMatcher<ProfileResource>() {
            @Override
            public boolean matches(Object item) {
                final ProfileResource profileResource = (ProfileResource) item;
                return profileResource.getName().equals(name) &&
                        profileResource.getLanguage().equals(language) &&
                        profileResource.getDescription().equals(content);
            }

            @Override
            public void describeTo(Description description) {

            }
        };
    }
}