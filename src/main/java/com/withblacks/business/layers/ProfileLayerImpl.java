package com.withblacks.business.layers;

import com.withblacks.business.entity.Profiler;
import com.withblacks.repository.profile.ProfilerRepositoryLayer;
import com.withblacks.repository.user.UserRepositoryLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static java.util.Collections.EMPTY_LIST;

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
    public List<Profiler> findAll() {
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
    public void delete(final Long id) throws NoSuchElementException, UnsupportedOperationException, ClassCastException {
        // Do something here
        repository.delete(id);
    }
}
