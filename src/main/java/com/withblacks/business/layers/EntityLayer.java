package com.withblacks.business.layers;


import java.util.NoSuchElementException;

public interface EntityLayer<T> {

    T find(final String entityName) throws NoSuchElementException;

    Iterable<T> findAll();

    T find(final Long id) throws NoSuchElementException;

    Iterable<T> create(final T entity) throws IllegalArgumentException, NullPointerException, ClassCastException;

    Iterable<T> update(final Long id, final T entity) throws NoSuchElementException, ClassCastException, IllegalArgumentException;

    void delete(final Long id) throws NoSuchElementException, UnsupportedOperationException, ClassCastException;
}
