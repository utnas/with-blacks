package com.withblacks.rest.user;

import com.withblacks.rest.user.dto.LinkDecorator;
import org.springframework.http.ResponseEntity;

public interface UserRest<T, E> extends LinkDecorator<T, E> {

    ResponseEntity<?> findAll();

    ResponseEntity<?> findById(final Long id);

    ResponseEntity<?> create(final T resource);

    ResponseEntity<?> update(final Long id, final T resource);

    ResponseEntity<?> delete(final Long id);

    Iterable<T> addLinks(final Iterable<T> resources);

    T addLinks(final T resource);
}