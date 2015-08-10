package com.withblacks.facade.project.dto;

import com.withblacks.business.entities.project.ProjectBuilder;
import com.withblacks.business.entities.project.Project;
import com.withblacks.facade.project.dto.ProjectDto;
import com.withblacks.facade.project.dto.ProjectDtoBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

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
        final List<ProjectDto> result = newArrayList();
        for (final Project project : projects) {
            result.add(convertToDto(project));
        }
        return result;
    }
}