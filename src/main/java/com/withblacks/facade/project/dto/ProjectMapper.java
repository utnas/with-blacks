package com.withblacks.facade.project.dto;

import com.withblacks.business.entities.project.Project;
import com.withblacks.business.entities.project.ProjectBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.google.common.collect.Iterables.transform;
import static com.google.common.collect.Lists.newArrayList;
import static java.util.Collections.EMPTY_LIST;

@Component
public class ProjectMapper {

    @Autowired
    public ProjectDto convertToDto(final Project project) {
        return new ProjectDtoBuilder().setName(project.getName()).build();
    }

    public static ProjectDto convertToProjectDto(final Project project) {
        return new ProjectDtoBuilder().setName(project.getName()).build();
    }

    public static Project convertToProject(final ProjectDto projectDto) {
        return new ProjectBuilder().setName(projectDto.getName()).build();
    }

    public static List<Project> convertToProjects(final Iterable<ProjectDto> projects) {
        try {
            return newArrayList(transform(projects, ProjectMapper::convertToProject));
        } catch (IndexOutOfBoundsException e) {
            return EMPTY_LIST;
        }
    }

    public static List<ProjectDto> convertToDtos(final List<Project> projects) {
        try {
            return newArrayList(transform(projects, ProjectMapper::convertToProjectDto));
        } catch (IndexOutOfBoundsException e) {
            return EMPTY_LIST;
        }
    }

}
