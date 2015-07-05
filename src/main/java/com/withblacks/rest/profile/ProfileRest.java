package com.withblacks.rest.profile;

import com.withblacks.business.entity.ProfileResource;
import org.springframework.http.ResponseEntity;

public interface ProfileRest extends RestLayer{

    ResponseEntity<?> findAll();

    ResponseEntity<?> findById(final Long id);

    ResponseEntity<?> create(final ProfileResource profileResource);

    ResponseEntity<?> update(final Long id, final ProfileResource profileResource);

    ResponseEntity<?> delete(final Long id);
}
