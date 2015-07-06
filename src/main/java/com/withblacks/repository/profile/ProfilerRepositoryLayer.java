package com.withblacks.repository.profile;

import com.withblacks.business.entity.Profiler;
import com.withblacks.repository.user.RepositoryLayer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class ProfilerRepositoryLayer implements RepositoryLayer<Profiler> {

    @Override
    public Profiler find(String name) throws NoSuchElementException {
        return null;
    }

    @Override
    public List<Profiler> findAll() {
        return null;
    }

    @Override
    public Profiler find(Long id) throws NoSuchElementException {
        return null;
    }

    @Override
    public Profiler save(Profiler entity) throws IllegalArgumentException, NullPointerException, ClassCastException {
        return null;
    }

    @Override
    public boolean modify(Long id, Profiler entity) throws NoSuchElementException, ClassCastException, IllegalArgumentException {
        return false;
    }

    @Override
    public void delete(Long id) throws NoSuchElementException, UnsupportedOperationException, ClassCastException {

    }
}
