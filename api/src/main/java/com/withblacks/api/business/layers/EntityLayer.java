package com.withblacks.api.business.layers;


import java.util.List;
import java.util.NoSuchElementException;

public interface EntityLayer<T> {

    T find(final String entityName) throws NoSuchElementException;

    List<T> findAll();

    T find(final Long id) throws NoSuchElementException;

    T create(final T entity) throws IllegalArgumentException, NullPointerException, ClassCastException;

    T update(final Long id, final T entity) throws NoSuchElementException, ClassCastException, IllegalArgumentException;

    void delete(final Long id) throws NoSuchElementException, UnsupportedOperationException, ClassCastException;
}
