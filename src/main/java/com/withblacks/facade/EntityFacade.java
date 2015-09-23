package com.withblacks.facade;

import java.util.NoSuchElementException;

public interface EntityFacade<T> {

    T getOne(final String userName);

    Iterable<T> getAll();

    T getOne(final Long id) throws NoSuchElementException;

    T create(final T dto) throws NoSuchElementException;

    T update(final Long id, final T dto) throws NoSuchElementException, ClassCastException, IllegalArgumentException;

    void remove(final Long id) throws NoSuchElementException;
}
