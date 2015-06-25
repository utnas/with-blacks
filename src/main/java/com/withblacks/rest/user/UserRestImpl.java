package com.withblacks.rest.user;

import com.withblacks.facade.user.UserFacadeLayer;
import com.withblacks.rest.user.dto.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

import static com.withblacks.rest.user.dto.LinkDecorator.addLinks;
import static java.util.Optional.of;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/users")
public final class UserRestImpl implements UserRest {

    private final transient UserFacadeLayer userFacadeLayer;

    @Autowired
    public UserRestImpl(final UserFacadeLayer userFacadeLayer) {
        this.userFacadeLayer = userFacadeLayer;
    }

    @RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {
        final Iterable<UserResource> resources = userFacadeLayer.getUsers();
        return responseEntity(addLinks(resources, of(UserRestImpl.class)), OK);
    }

    @RequestMapping(value = "/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findById(@PathVariable("id") final Long id) {
        try {
            final UserResource resource = userFacadeLayer.getUser(id);
            return responseEntity(addLinks(resource, of(UserRestImpl.class)), OK);

        } catch (NoSuchElementException e) {
            return responseEntity(NOT_FOUND);
        }
    }

    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody final UserResource userResource) {
        try {
            final UserResource resource = userFacadeLayer.create(userResource);
            return responseEntity(addLinks(resource, of(UserRestImpl.class)), CREATED);

        } catch (Throwable e) {
            return responseEntity(CONFLICT);
        }
    }

    @RequestMapping(value = "/{id}", method = PATCH, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> patch(@PathVariable("id") final Long id, @RequestBody final UserResource resource) {
        try {
            userFacadeLayer.update(id, resource);
            return responseEntity(OK);

        } catch (NoSuchElementException e) {
            return responseEntity(NOT_FOUND);
        } catch (ClassCastException e) {
            return responseEntity(NOT_ACCEPTABLE);
        } catch (IllegalArgumentException e) {
            return responseEntity(BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{id}", method = PUT, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable("id") final Long id, @RequestBody final UserResource resource) {
        try {
            userFacadeLayer.update(id, resource);
            return responseEntity(OK);

        } catch (NoSuchElementException e) {
            return responseEntity(NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") final Long id) {
        try {
            userFacadeLayer.remove(id);
            return responseEntity(OK);

        } catch (NoSuchElementException e) {
            return responseEntity(NOT_FOUND);
        } catch (NullPointerException e) {
            return responseEntity(NOT_FOUND);
        }
    }

    private ResponseEntity<?> responseEntity(final UserResource resource, final HttpStatus created) {
        return new ResponseEntity<UserResource>(resource, created);
    }

    private ResponseEntity<?> responseEntity(final HttpStatus status) {
        return new ResponseEntity<>(status);
    }

    private ResponseEntity<Iterable> responseEntity(final Iterable<UserResource> resources, final HttpStatus status) {
        return new ResponseEntity<>(resources, status);
    }

}
