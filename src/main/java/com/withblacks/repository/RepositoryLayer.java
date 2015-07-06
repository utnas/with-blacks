package com.withblacks.repository;

import com.withblacks.business.entity.User;

import java.util.List;
import java.util.NoSuchElementException;

public interface RepositoryLayer<T> {

    T find(final String name) throws NoSuchElementException;

    List<T> findAll();

    T find(final Long id) throws NoSuchElementException;

    T save(final T entity) throws IllegalArgumentException, NullPointerException, ClassCastException ;

    boolean modify(final Long id, final T entity) throws NoSuchElementException, ClassCastException, IllegalArgumentException;

    boolean delete(final Long id) throws NoSuchElementException, UnsupportedOperationException, ClassCastException;
}
