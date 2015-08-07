package com.withblacks.facade.project;

import com.withblacks.business.builder.ProjectBuilder;
import com.withblacks.business.entities.Project;
import com.withblacks.facade.project.dto.ProjectDto;
import com.withblacks.facade.project.dto.ProjectDtoBuilder;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class ProjectMapper {

    public ProjectDto convertToDto(final Project project) {
        return new ProjectDtoBuilder().setName(project.getName()).build();
    }

    public Project convertToProject(final ProjectDto projectDto) {
        return new ProjectBuilder().setName(projectDto.getName()).build();
    }

    public Iterable<ProjectDto> convertToDtos(final Iterable<Project> projects) {
        final List<ProjectDto> result = newArrayList();
        for (final Project project : projects) {
            result.add(convertToDto(project));
        }
        return result;
    }
}
