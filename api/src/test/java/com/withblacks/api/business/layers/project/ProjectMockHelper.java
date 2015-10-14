package com.withblacks.api.business.layers.project;

import com.withblacks.api.business.entities.project.Project;
import com.withblacks.api.facade.project.dto.ProjectDto;
import com.withblacks.api.facade.project.dto.ProjectMapper;
import org.mockito.Mockito;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ProjectMockHelper {

    public static Project mockProject(final String name, List emptyList) {
        final Project project = Mockito.mock(Project.class);
        doReturn(name).when(project).getName();
        doReturn(emptyList).when(project).getMembers();
        return project;
    }

    public static ProjectDto mockProjectDto(final String name) {
        final ProjectDto dto = mock(ProjectDto.class);
        doReturn(name).when(dto).getName();

        return dto;
    }

    public static ProjectMapper mockProjectMapper(ProjectDto projectDto, Project project) {
        ProjectMapper mapper = mock(ProjectMapper.class);
        doReturn(projectDto).when(mapper).convertToDto(project);
        doReturn(singletonList(projectDto)).when(mapper).convertToDtos(singletonList(project));
        doReturn(project).when(mapper).convertToProject(projectDto);
        return mapper;
    }
}
