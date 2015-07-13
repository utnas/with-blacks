package com.withblacks.business.layers;

import com.withblacks.business.entity.Profiler;
import com.withblacks.repository.profile.ProfilerRepositoryLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class ProfileLayerImpl implements ProfileLayer {

    private final transient ProfilerRepositoryLayer repository;

    @Autowired
    public ProfileLayerImpl(final ProfilerRepositoryLayer repository) {
        this.repository = repository;
    }

    @Override
    public Profiler find(final String entityName) throws NoSuchElementException {
        return repository.find(entityName);
    }

    @Override
    public Iterable<Profiler> findAll() {
        return repository.findAll();
    }

    @Override
    public Profiler find(long id) throws NoSuchElementException {
        return repository.find(id);
    }

    @Override
    public Profiler create(final Profiler entity) throws IllegalArgumentException, NullPointerException, ClassCastException {
        return repository.save(entity);
    }

    @Override
    public boolean update(final Long id, final Profiler entity) throws NoSuchElementException, ClassCastException, IllegalArgumentException {
        return repository.modify(id, entity);
    }

    @Override
    public boolean delete(final Long id) throws NoSuchElementException, UnsupportedOperationException, ClassCastException {
        return repository.delete(id);
    }
}
