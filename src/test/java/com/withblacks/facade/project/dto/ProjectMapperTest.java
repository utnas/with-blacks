package com.withblacks.facade.project.dto;

import com.google.common.collect.Iterables;
import com.withblacks.business.entities.project.Project;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.withblacks.business.layers.project.ProjectMockHelper.mockProject;
import static com.withblacks.business.layers.project.ProjectMockHelper.mockProjectDto;
import static com.withblacks.facade.project.dto.ProjectMapper.convertToDtos;
import static com.withblacks.facade.project.dto.ProjectMapper.convertToProject;
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
        final Project project = mockProject("Iron", emptyList());
        assertThat(mapper.convertToDto(project).getName(), is("Iron"));
    }

    @Test
    public void testConvertToProject() throws Exception {
        final ProjectDto dto = mockProjectDto("Iron");
        assertThat(convertToProject(dto).getName(), is("Iron"));
    }

    @Test
    public void testConvertToDtos() throws Exception {
        final List<Project> projects = asList(mockProject("Iron", emptyList()), mockProject("Iron", emptyList()));
        assertThat(Iterables.size(convertToDtos(projects)), is(2));
    }
}