package com.withblacks.facade.project;

import com.withblacks.facade.project.dto.ProjectDto;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ProjectFacadeLayerImpl implements ProjectFacadeLayer {

    public ProjectFacadeLayerImpl() {
    }

    @Override
    public ProjectDto getProject(String userName) {
        return null;
    }

    @Override
    public ProjectDto getProject(Long id) throws NoSuchElementException {
        return null;
    }

    @Override
    public Iterable<ProjectDto> getProjects() {
        return null;
    }

    @Override
    public ProjectDto create(ProjectDto dto) throws NoSuchElementException {
        return null;
    }

    @Override
    public ProjectDto update(Long id, ProjectDto dto) throws NoSuchElementException, ClassCastException, IllegalArgumentException {
        return null;
    }

    @Override
    public void remove(Long id) throws NoSuchElementException {

    }
}
