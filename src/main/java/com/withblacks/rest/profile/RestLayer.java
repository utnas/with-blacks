package com.withblacks.rest.profile;

import com.withblacks.business.entity.ProfileResource;
import org.springframework.http.ResponseEntity;

public interface RestLayer<T> {

    ResponseEntity<?> findAll();

    ResponseEntity<?> findById(final Long id);

    ResponseEntity<?> create(final T resource);

    ResponseEntity<?> update(final Long id, final T resource);

    ResponseEntity<?> delete(final Long id);
}
