package com.withblacks.api.business.entities.project;

import com.withblacks.api.business.entities.user.User;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
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
    public void itShouldAddMember() {
        User user = mock(User.class);

        boolean result = project.addMember(user);

        assertTrue(result);
        assertThat(project.getMembers(), hasItem(user));
    }
}