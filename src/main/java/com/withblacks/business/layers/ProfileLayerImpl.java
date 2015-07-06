package com.withblacks.business.layers;

import com.withblacks.business.entity.Profiler;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static java.util.Collections.EMPTY_LIST;

@Component
public class ProfileLayerImpl implements ProfileLayer {

    @Override
    public Profiler find(final String entityName) throws NoSuchElementException {
        return null;
    }

    @Override
    public List<Profiler> findAll() {
        return EMPTY_LIST;
    }

    @Override
    public Profiler find(long id) throws NoSuchElementException {
        return null;
    }

    @Override
    public Profiler create(final Profiler entity) throws IllegalArgumentException, NullPointerException, ClassCastException {
        return null;
    }

    @Override
    public boolean update(final Long id, final Profiler entity) throws NoSuchElementException, ClassCastException, IllegalArgumentException {
        return false;
    }

    @Override
    public void delete(final Long id) throws NoSuchElementException, UnsupportedOperationException, ClassCastException {
        // Do something here
    }
}
