package com.withblacks.rest.user;

import com.withblacks.rest.RestLayer;
import org.springframework.http.ResponseEntity;

public interface UserRest<UserResource> extends RestLayer<UserResource> {

    ResponseEntity<?> findAll();

    ResponseEntity<?> findById(final Long id);

    ResponseEntity<?> create(final UserResource resource);

    ResponseEntity<?> update(final Long id, final UserResource resource);

    ResponseEntity<?> delete(final Long id);
}