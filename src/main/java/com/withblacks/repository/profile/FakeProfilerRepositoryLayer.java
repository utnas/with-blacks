package com.withblacks.repository.profile;

import com.withblacks.business.entity.Profiler;
import com.withblacks.repository.RepositoryLayer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class FakeProfilerRepositoryLayer implements ProfilerRepositoryLayer{

    @Override
    public Profiler find(final String name) throws NoSuchElementException {
        return null;
    }

    @Override
    public List<Profiler> findAll() {
        return null;
    }

    @Override
    public Profiler find(final Long id) throws NoSuchElementException {
        return null;
    }

    @Override
    public Profiler save(final Profiler entity) throws IllegalArgumentException, NullPointerException, ClassCastException {
        return null;
    }

    @Override
    public boolean modify(final Long id, final Profiler entity) throws NoSuchElementException, ClassCastException, IllegalArgumentException {
        return false;
    }

    @Override
    public boolean delete(final Long id) throws NoSuchElementException, UnsupportedOperationException, ClassCastException {
        return false;
    }
}
