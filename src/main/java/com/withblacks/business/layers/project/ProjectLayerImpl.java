package com.withblacks.business.layers.project;

import com.withblacks.business.entities.project.Project;
import com.withblacks.repository.project.ProjectRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

import static com.google.common.collect.Lists.newArrayList;

@Component
public class ProjectLayerImpl implements ProjectLayer {

    private ProjectRepository repository;

    public ProjectLayerImpl() {
    }

    public ProjectLayerImpl(final ProjectRepository repository) {
        this.repository = repository;
    }

    @Override
    public Project find(final String entityName) throws NoSuchElementException {
        return repository.findByName(entityName);
    }

    @Override
    public List<Project> findAll() {
        return newArrayList(repository.findAll());
    }

    @Override
    public Project find(final Long id) throws NoSuchElementException {
        return repository.findOne(id);
    }

    @Override
    public Project create(final Project entity) throws IllegalArgumentException, NullPointerException, ClassCastException {
        return repository.save(entity);
    }

    @Override
    public Project update(final Long id, final Project entity) throws NoSuchElementException, ClassCastException, IllegalArgumentException {
        return repository.save(entity);
    }

    @Override
    public void delete(final Long id) throws NoSuchElementException, UnsupportedOperationException, ClassCastException {
        repository.delete(id);
    }
}