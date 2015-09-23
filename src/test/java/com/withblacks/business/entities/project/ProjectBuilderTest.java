package com.withblacks.business.entities.project;

import com.withblacks.business.entities.user.User;
import org.junit.Before;
import org.junit.Test;

import static com.withblacks.business.entities.user.GENDER.FEMALE;
import static com.withblacks.business.entities.user.GENDER.MALE;
import static com.withblacks.business.layers.user.UserMockHelper.mockUser;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
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
        User iron = mockUser("Iron", "Man", MALE);
        User cat = mockUser("Cat", "Women", FEMALE);

        Project project = builder.setName("Iron")
                .addMember(iron)
                .addMembers(singletonList(cat))
                .build();

        assertThat(project.getMembers(), hasItems(iron, cat));
    }
}