package com.withblacks.rest;

import org.springframework.http.ResponseEntity;

public interface RestLayer<T> extends LinkDecorator<T> {

    ResponseEntity<?> findAll();

    ResponseEntity<?> findById(final Long id);

    ResponseEntity<?> create(final T resource);

    ResponseEntity<?> update(final Long id, final T resource);

    ResponseEntity<?> delete(final Long id);
}
