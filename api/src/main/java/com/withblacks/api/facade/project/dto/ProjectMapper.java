package com.withblacks.api.facade.project.dto;

import com.google.common.base.Function;
import com.withblacks.api.business.entities.project.Project;
import com.withblacks.api.business.entities.project.ProjectBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;
import java.util.List;

import static com.google.common.collect.Iterables.transform;
import static com.google.common.collect.Lists.newArrayList;
import static java.util.Collections.emptyList;

@Component
public class ProjectMapper {

    public ProjectMapper() {
    }

    @Autowired
    public ProjectDto convertToDto(final Project project) {
        return new ProjectDtoBuilder().setName(project.getName()).build();
    }

    public Project convertToProject(final ProjectDto projectDto) {
        return new ProjectBuilder().setName(projectDto.getName()).build();
    }

    public List<Project> convertToProjects(final Iterable<ProjectDto> projects) {
        try {
            return newArrayList(transform(projects, toProject()));
        } catch (IndexOutOfBoundsException e) {
            return emptyList();
        }
    }

    public List<ProjectDto> convertToDtos(final List<Project> projects) {
        try {
            return newArrayList(transform(projects, toProjectDto()));
        } catch (IndexOutOfBoundsException e) {
            return emptyList();
        }
    }

    private Function<ProjectDto, Project> toProject() {
        return new Function<ProjectDto, Project>() {
            @Nullable
            public Project apply(ProjectDto projectDto) {
                return new ProjectBuilder().setName(projectDto.getName()).build();
            }
        };
    }

    private Function<Project, ProjectDto> toProjectDto() {
        return new Function<Project, ProjectDto>() {
            @Nullable
            public ProjectDto apply(Project project) {
                return new ProjectDtoBuilder().setName(project.getName()).build();
            }
        };
    }
}
