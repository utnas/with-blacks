package com.withblacks.rest.user;

import com.withblacks.facade.user.UserFacadeLayer;
import com.withblacks.rest.user.dto.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/users")
public class UserRestImpl implements UserRest<UserResource> {

    private final transient UserFacadeLayer userFacadeLayer;

    @Autowired
    public UserRestImpl(final UserFacadeLayer userFacadeLayer) {
        this.userFacadeLayer = userFacadeLayer;
    }

    @RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<Iterable<UserResource>>(userFacadeLayer.getUsers(), OK);
    }

    @RequestMapping(value = "/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findById(@PathVariable("id") final Long id) {
        try {
            return new ResponseEntity<UserResource>(userFacadeLayer.getUser(id), OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity(NOT_FOUND);
        }
    }

    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody final UserResource userResource) {
        try {
            return new ResponseEntity<UserResource>(userFacadeLayer.create(userResource), CREATED);
        } catch (Throwable e) {
            return new ResponseEntity(CONFLICT);
        }
    }

    @RequestMapping(value = "/{id}", method = PATCH, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> patch(@PathVariable("id") final Long id, @RequestBody final UserResource resource) {
        try {
            //userFacadeLayer.update(id, resource);
            return new ResponseEntity(OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity(NOT_FOUND);
        } catch (ClassCastException e) {
            return new ResponseEntity(NOT_ACCEPTABLE);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{id}", method = PUT, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable("id") final Long id, @RequestBody final UserResource resource) {
        try {
            // userFacadeLayer.update(id, resource);
            return new ResponseEntity(OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity(NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") final Long id) {
        try {
            userFacadeLayer.remove(id);
            return new ResponseEntity(OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity(NOT_FOUND);
        } catch (NullPointerException e) {
            return new ResponseEntity(NOT_FOUND);
        }
    }
}
