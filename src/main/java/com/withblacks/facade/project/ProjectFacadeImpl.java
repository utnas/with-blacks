package com.withblacks.facade.project;

import com.withblacks.business.layers.project.ProjectLayer;
import com.withblacks.facade.project.dto.ProjectDto;
import com.withblacks.facade.project.dto.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

import static com.withblacks.facade.project.dto.ProjectMapper.convertToDtos;
import static com.withblacks.facade.project.dto.ProjectMapper.convertToProject;

@Component
public class ProjectFacadeImpl implements ProjectFacade {

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
        return convertToDtos(layer.findAll());
    }

    @Override
    public ProjectDto create(final ProjectDto dto) throws NoSuchElementException {
        return mapper.convertToDto(layer.create(convertToProject(dto)));
    }

    @Override
    public ProjectDto update(final Long id, final ProjectDto dto) throws NoSuchElementException, ClassCastException, IllegalArgumentException {
        return mapper.convertToDto(layer.update(id, convertToProject(dto)));
    }

    @Override
    public void remove(final Long id) throws NoSuchElementException {
        layer.delete(id);
    }
}
