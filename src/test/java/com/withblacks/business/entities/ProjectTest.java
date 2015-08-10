package com.withblacks.business.entities;

import com.withblacks.business.entities.project.Project;
import com.withblacks.business.entities.project.ProjectBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
}