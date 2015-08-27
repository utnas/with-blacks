package com.withblacks.facade.project.dto;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.withblacks.business.entities.project.ProjectBuilder;
import com.withblacks.business.entities.project.Project;
import com.withblacks.facade.project.dto.ProjectDto;
import com.withblacks.facade.project.dto.ProjectDtoBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;
import java.util.Collections;
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

    public Project convertToProject(final ProjectDto projectDto) {
        return new ProjectBuilder().setName(projectDto.getName()).build();
    }

    public Iterable<ProjectDto> convertToDtos(final Iterable<Project> projects) {
        try {
            return transform(projects, toDto());
        } catch (IndexOutOfBoundsException e) {
            return EMPTY_LIST;
        }
    }

    private Function<Project, ProjectDto> toDto() {
        return (project) -> convertToDto(project);
    }
}
