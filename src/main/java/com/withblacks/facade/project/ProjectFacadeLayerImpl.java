package com.withblacks.facade.project;

import com.withblacks.business.layers.project.ProjectLayer;
import com.withblacks.facade.project.dto.ProjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ProjectFacadeLayerImpl implements ProjectFacadeLayer {

    private ProjectLayer layer;
    private ProjectMapper mapper;

    public ProjectFacadeLayerImpl() {
    }

    @Autowired
    public ProjectFacadeLayerImpl(final ProjectLayer layer, final ProjectMapper mapper) {
        this.layer = layer;
        this.mapper = mapper;
    }

    @Override
    public ProjectDto getProject(final String userName) {
        return mapper.convertToDto(layer.find(userName));
    }

    @Override
    public ProjectDto getProject(final Long id) throws NoSuchElementException {
        return mapper.convertToDto(layer.find(id));
    }

    @Override
    public Iterable<ProjectDto> getProjects() {
        return mapper.convertToDtos(layer.findAll());
    }

    @Override
    public ProjectDto create(final ProjectDto dto) throws NoSuchElementException {
        return mapper.convertToDto(layer.create(mapper.convertToProject(dto)));
    }

    @Override
    public ProjectDto update(final Long id, final ProjectDto dto) throws NoSuchElementException, ClassCastException, IllegalArgumentException {
        return mapper.convertToDto(layer.update(id, mapper.convertToProject(dto)));
    }

    @Override
    public void remove(final Long id) throws NoSuchElementException {
        layer.delete(id);
    }
}
