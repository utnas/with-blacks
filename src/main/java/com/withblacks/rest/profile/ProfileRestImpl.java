package com.withblacks.rest.profile;

import com.withblacks.rest.profile.dto.mapper.ProfileResource;
import com.withblacks.facade.profile.ProfileFacadeLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/profiles")
public class ProfileRestImpl implements ProfileRest<ProfileResource> {

    private final transient ProfileFacadeLayer profileFacadeLayer;

    @Autowired
    public ProfileRestImpl(final ProfileFacadeLayer profileFacadeLayer) {
        this.profileFacadeLayer = profileFacadeLayer;
    }

    @Override
    @RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(addLinks(profileFacadeLayer.getProfiles()), OK);
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
    public ProfileResource addLink(final ProfileResource resource) {
        return null;
    }
}
