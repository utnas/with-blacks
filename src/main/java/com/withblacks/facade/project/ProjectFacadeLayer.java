package com.withblacks.facade.project;

import com.withblacks.facade.project.dto.ProjectDto;

import java.util.NoSuchElementException;

public interface ProjectFacadeLayer {

    ProjectDto getProject(final String userName);

    ProjectDto getProject(final Long id) throws NoSuchElementException;

    Iterable<ProjectDto> getProjects();

    ProjectDto create(final ProjectDto dto) throws NoSuchElementException;

    ProjectDto update(final Long id, final ProjectDto dto) throws NoSuchElementException, ClassCastException, IllegalArgumentException;

    void remove(final Long id) throws NoSuchElementException;
}
