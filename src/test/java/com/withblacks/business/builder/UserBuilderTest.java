package com.withblacks.business.builder;

import org.junit.Test;

import static com.withblacks.business.builder.UserBuilder.build;
import static com.withblacks.business.entity.GENDER.FEMALE;
import static com.withblacks.rest.user.utils.MatcherUtils.hasProperties;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;

public class UserBuilderTest {

    @Test
    public void testItShouldBuildUserWithId() throws Exception {
        assertThat(build(1, "FirstName", "LastName", FEMALE), hasProperties(1L, "FirstName", "LastName", FEMALE));
    }

    @Test
    public void testItShouldBuildUserWithoutId() throws Exception {
        assertThat(build("FirstName", "LastName", FEMALE), hasProperties("FirstName", "LastName", FEMALE));
    }
}