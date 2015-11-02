package com.withblacks.api.business.entities.project;

import com.withblacks.api.business.entities.user.GENDER;
import com.withblacks.api.business.entities.user.User;
import org.junit.Before;
import org.junit.Test;

import static com.withblacks.api.business.layers.user.UserMockHelper.mockUser;
import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;

public class ProjectBuilderTest {

    private ProjectBuilder builder;

    @Before
    public void setUp() {
        builder = new ProjectBuilder();
    }

    @Test
    public void testSetName() throws Exception {
        final Project project = builder.setName("Iron").build();
        assertThat(project.getName(), is("Iron"));
    }

    @Test
    public void testBuild() throws Exception {
        final Project project = builder.setName("Iron").build();
        assertThat(project.getName(), is("Iron"));
    }

    @Test
    public void itShouldAddMember() {
        User iron = mockUser("Iron", "Man", GENDER.MALE);
        User cat = mockUser("Cat", "Women", GENDER.FEMALE);

        Project project = builder.setName("Iron")
                .addMember(iron)
                .addMembers(singletonList(cat))
                .build();

        assertThat(project.getMembers(), hasItems(iron, cat));
    }
}