package com.withblacks.rest.user;

import org.springframework.http.ResponseEntity;

public interface UserRest {

    ResponseEntity<?> findAll();

    ResponseEntity<?> findById(final Long id);

    ResponseEntity<?> create(final UserResource userResource);

    ResponseEntity<?> update(final Long id, final UserResource userResource);

    ResponseEntity<?> delete(final Long id);
}