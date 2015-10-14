package com.withblacks.api.facade.project.dto;

import com.google.common.collect.Iterables;
import com.withblacks.api.business.entities.project.Project;
import com.withblacks.api.business.layers.project.ProjectMockHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ProjectMapperTest {

    private ProjectMapper mapper;

    @Before
    public void setUp() throws Exception {
        mapper = new ProjectMapper();
    }

    @Test
    public void testConvertToDto() throws Exception {
        final Project project = ProjectMockHelper.mockProject("Iron", emptyList());
        assertThat(mapper.convertToDto(project).getName(), is("Iron"));
    }

    @Test
    public void testConvertToProject() throws Exception {
        final ProjectDto dto = ProjectMockHelper.mockProjectDto("Iron");
        assertThat(mapper.convertToProject(dto).getName(), is("Iron"));
    }

    @Test
    public void testConvertToDtos() throws Exception {
        final List<Project> projects = asList(ProjectMockHelper.mockProject("Iron", emptyList()), ProjectMockHelper.mockProject("Iron", emptyList()));
        assertThat(Iterables.size(mapper.convertToDtos(projects)), is(2));
    }
}