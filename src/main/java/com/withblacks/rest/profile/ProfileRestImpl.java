package com.withblacks.rest.profile;

import com.withblacks.business.entity.ProfileResource;
import com.withblacks.facade.profile.ProfileFacadeLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class ProfileRestImpl implements ProfileRest<ProfileResource> {

    private final transient ProfileFacadeLayer profileFacadeLayer;

    @Autowired
    public ProfileRestImpl(final ProfileFacadeLayer profileFacadeLayer) {
        this.profileFacadeLayer = profileFacadeLayer;
    }

    @Override
    public ResponseEntity<?> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<?> findById(final Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> create(final ProfileResource resource) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(final Long id, final ProfileResource resource) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(final Long id) {
        return null;
    }

    @Override
    public Iterable<ProfileResource> addLinks(final Iterable<ProfileResource> resources) {
        return null;
    }

    @Override
    public ProfileResource addLinks(final ProfileResource resource) {
        return null;
    }
}
