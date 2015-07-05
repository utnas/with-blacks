package com.withblacks.rest.profile;

import com.withblacks.business.entity.ProfileResource;
import com.withblacks.facade.profile.ProfileFacadeLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class ProfileRestImpl implements ProfileRest {


    private final transient ProfileFacadeLayer profileFacadeLayer;

    @Autowired
    public ProfileRestImpl(ProfileFacadeLayer profileFacadeLayer) {
        this.profileFacadeLayer = profileFacadeLayer;
    }

    @Override
    public ResponseEntity<?> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> create(Object resource) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(Long id, Object resource) {
        return null;
    }

    @Override
    public ResponseEntity<?> create(ProfileResource profileResource) {
        return null;
    }

    @Override
    public ResponseEntity<?> update(Long id, ProfileResource profileResource) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return null;
    }
}
