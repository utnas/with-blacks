package com.withblacks.business.entities.user;

import com.withblacks.business.entities.project.Project;
import org.junit.Before;
import org.junit.Test;

import static com.withblacks.business.entities.user.GENDER.FEMALE;
import static com.withblacks.business.entities.user.UserBuilder.build;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;

public class UserTest {

    private User user;

    @Before
    public void setUp() throws Exception {
        user = build("Super", "Man", FEMALE);
    }

    @Test
    public void testGetFirstName() throws Exception {
        assertThat(user.getFirstName(), is("Super"));
    }

    @Test
    public void testGetLastName() throws Exception {
        assertThat(user.getLastName(), is("Man"));
    }

    @Test
    public void testGetGender() throws Exception {
        assertThat(user.getGender(), is(FEMALE));
    }

    @Test
    public void testEquals() throws Exception {
        assertThat(user, is(user));
    }

    @Test
    public void itShouldAddAProject() {
        assertThat(user.addProject(mock(Project.class)), is(true));
    }
}
