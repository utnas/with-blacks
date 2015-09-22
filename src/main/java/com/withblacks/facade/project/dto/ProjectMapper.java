package com.withblacks.facade.project.dto;

import com.google.common.base.Function;
import com.withblacks.business.entities.project.Project;
import com.withblacks.business.entities.project.ProjectBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;
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

    public ProjectDto convertToProjectDto(final Project project) {
        return new ProjectDtoBuilder().setName(project.getName()).build();
    }

    public  Project convertToProject(final ProjectDto projectDto) {
        return new ProjectBuilder().setName(projectDto.getName()).build();
    }

    public  List<Project> convertToProjects(final Iterable<ProjectDto> projects) {
        try {
            return newArrayList(transform(projects, toProject()));
        } catch (IndexOutOfBoundsException e) {
            return EMPTY_LIST;
        }
    }


    public  List<ProjectDto> convertToDtos(final List<Project> projects) {
        try {
            return newArrayList(transform(projects, toProjectDto()));
        } catch (IndexOutOfBoundsException e) {
            return EMPTY_LIST;
        }
    }

    private Function<ProjectDto, Project> toProject() {
        return input -> new ProjectBuilder().setName(input.getName()).build();
    }

    private Function<Project, ProjectDto> toProjectDto() {
        return input -> new ProjectDtoBuilder().setName(input.getName()).build();
    }
}
