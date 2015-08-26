package com.withblacks.business.entities.project;

import com.withblacks.business.entities.user.User;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class ProjectTest {

    private Project project;

    @Before
    public void setUp() throws Exception {
        project = new ProjectBuilder().setName("Global").build();
    }

    @Test
    public void itShouldSetName() {
        project.setName("Iron");
        assertThat(project.getName(), is("Iron"));
    }

    @Test
    public <T> void itShoulAddMember() {
        User user = mock(User.class);
        project.addMember(user);
        assertThat(project.getMembers(), hasItem(user));
    }
}