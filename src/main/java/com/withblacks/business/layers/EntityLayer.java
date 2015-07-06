package com.withblacks.business.layers;

import com.withblacks.business.entity.Profiler;

import java.util.List;
import java.util.NoSuchElementException;

public interface EntityLayer<T> {

    T find(final String entityName) throws NoSuchElementException;

    List<T> findAll();

    T find(final long id) throws NoSuchElementException;

    T create(final T entity) throws IllegalArgumentException, NullPointerException, ClassCastException;

    boolean update(final Long id, final T entity) throws NoSuchElementException, ClassCastException, IllegalArgumentException;

    void delete(final Long id) throws NoSuchElementException, UnsupportedOperationException, ClassCastException;
}
