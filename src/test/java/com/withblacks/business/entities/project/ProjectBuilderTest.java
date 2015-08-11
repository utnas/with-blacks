package com.withblacks.business.entities.project;

import com.withblacks.business.entities.project.Project;
import com.withblacks.business.entities.project.ProjectBuilder;
import org.junit.Before;
import org.junit.Test;

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
        final Project iron = builder.setName("Iron").build();
        assertThat(iron.getName(), is("Iron"));
    }

    @Test
    public void testBuild() throws Exception {
        final Project iron = builder.setName("Iron").build();
        assertThat(iron.getName(), is("Iron"));
    }
}