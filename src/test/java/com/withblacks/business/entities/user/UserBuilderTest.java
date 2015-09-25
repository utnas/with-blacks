package com.withblacks.business.entities.user;

import com.withblacks.business.entities.project.Project;
import org.junit.Before;
import org.junit.Test;

import static com.google.common.collect.Iterables.getLast;
import static com.withblacks.business.entities.user.GENDER.MALE;
import static com.withblacks.business.layers.project.ProjectMockHelper.mockProject;
import static java.util.Collections.emptyList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserBuilderTest {

    private UserBuilder builder;

    @Before
    public void setUp() {
        builder = new UserBuilder();
    }

    @Test
    public void itShouldSetFirstName() {
        assertThat(builder.setFirstName("Iron").getFirstName(), is("Iron"));
    }

    @Test
    public void itShouldSetLastName() {
        assertThat(builder.setLastName("Man").getLastName(), is("Man"));
    }

    @Test
    public void itShouldSetGender() {
        assertThat(builder.setGender(MALE).getGender(), is(MALE));
    }

    @Test
    public void itShouldSetCredentials() {
        // When
        UserBuilder userBuilder = builder.setCredentials(new Credentials("NewLogin", "NewPassword"));
        Credentials credentials = userBuilder.getCredentials();
        //Then
        assertThat(credentials.getLogin(), is("NewLogin"));
        assertThat(credentials.getPassword(), is("NewPassword"));
    }

    @Test
    public void itShouldAddProject() {
        Project project = mockProject("Iron", emptyList());
        User user = builder.addProject(project).build();
        assertThat(getLast(user.getProjects()).getName(), is("Iron"));
    }

    @Test
    public void itShouldBuildUser() {
        builder.setFirstName("Iron")
                .setLastName("Man")
                .setGender(MALE);
        User user = builder.build();

        assertThat(user.getFirstName(), is("Iron"));
        assertThat(user.getLastName(), is("Man"));
        assertThat(user.getGender(), is(MALE));
    }
}