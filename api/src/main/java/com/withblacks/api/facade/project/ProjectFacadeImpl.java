package com.withblacks.api.facade.project;

import com.withblacks.api.business.layers.project.ProjectLayer;
import com.withblacks.api.facade.EntityFacade;
import com.withblacks.api.facade.project.dto.ProjectDto;
import com.withblacks.api.facade.project.dto.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class ProjectFacadeImpl implements EntityFacade<ProjectDto> {

    private ProjectLayer layer;
    private ProjectMapper mapper;

    public ProjectFacadeImpl() {
    }

    @Autowired
    public ProjectFacadeImpl(final ProjectLayer layer, final ProjectMapper mapper) {
        this.layer = layer;
        this.mapper = mapper;
    }

    @Override
    public ProjectDto getOne(final String userName) {
        return mapper.convertToDto(layer.find(userName));
    }

    @Override
    public ProjectDto getOne(final Long id) throws NoSuchElementException {
        return mapper.convertToDto(layer.find(id));
    }

    @Override
    public Iterable<ProjectDto> getAll() {
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
