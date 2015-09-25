package com.withblacks.business.entities.user;

import com.google.common.collect.Lists;
import com.withblacks.business.entities.project.Project;
import com.withblacks.business.entities.project.ProjectBuilder;
import org.junit.Before;
import org.junit.Test;

import static com.withblacks.business.entities.user.GENDER.FEMALE;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;

public class UserTest {

    private User user;

    @Before
    public void setUp() throws Exception {
        user = new UserBuilder()
                .setFirstName("Super")
                .setLastName("Man")
                .setGender(FEMALE)
                .setCredentials(new Credentials("userName", "Password"))
                .setProjects(Lists.<Project>newArrayList())
                .build();
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
        Project project = new ProjectBuilder().setName("NewProject").build();

        assertTrue(user.addOneProject(project));
        assertThat(user.getProjects(), hasItem(project));
    }

    @Test
    public void itShouldSetCredentials() {
        user.setCredentials("NewLogin", "NewPassword");
        assertThat(user.getCredentials().getLogin(), is("NewLogin"));
        assertThat(user.getCredentials().getPassword(), is("NewPassword"));
    }
}
