package com.withblacks.business.layers.project;

import com.withblacks.business.entities.project.Project;
import com.withblacks.facade.project.dto.ProjectMapper;
import com.withblacks.facade.project.dto.ProjectDto;
import org.mockito.Mockito;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ProjectMockHelper {

    public static Project mockProject(final String name) {
        final Project project = Mockito.mock(Project.class);
        doReturn(name).when(project).getName();

        return project;
    }

    public static ProjectDto mockProjectDto(final String name) {
        final ProjectDto dto = mock(ProjectDto.class);
        doReturn(name).when(dto).getName();

        return dto;
    }

    public static ProjectMapper mockProjectMapper(final ProjectDto projectDto, final Project project) {
        final ProjectMapper mapper = mock(ProjectMapper.class);

        doReturn(projectDto).when(mapper).convertToDto(project);
        doReturn(asList(projectDto)).when(mapper).convertToDtos(asList(project));
        doReturn(project).when(mapper).convertToProject(projectDto);

        return mapper;
    }
}
