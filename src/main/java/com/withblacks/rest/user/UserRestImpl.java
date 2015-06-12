package com.withblacks.rest.user;

import com.withblacks.business.entity.User;
import com.withblacks.facade.user.UserFacadeLayer;
import com.withblacks.rest.user.trasformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/users")
public class UserRestImpl implements UserRest {

    private UserFacadeLayer userFacadeLayer;
    private UserTransformer<User, UserResource> transformer;

    public UserRestImpl() {
    }

    @Autowired
    public UserRestImpl(UserFacadeLayer userFacadeLayer, UserTransformer<User, UserResource> transformer) {
        this.userFacadeLayer = userFacadeLayer;
        this.transformer = transformer;
    }

    @RequestMapping(method = GET)
    public ResponseEntity<?> findAll() {
        final Iterable<UserResource> userDtoList = transformer.convertTo(userFacadeLayer.getUsers(), UserRestImpl.class);
        return new ResponseEntity<Iterable>(userDtoList, OK);
    }

    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<UserResource> findById(@PathVariable("id") final Long id) {
        final UserResource userResource;
        try {
            userResource = transformer.convertTo(userFacadeLayer.getUser(id), UserRestImpl.class);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<UserResource>(NOT_FOUND);
        }
        return new ResponseEntity<UserResource>(userResource, OK);
    }

    @RequestMapping(method = POST)
    public ResponseEntity<UserResource> create(@RequestBody final UserResource userResource) {
        try {
            final User user = userFacadeLayer.create(transformer.convertFrom(userResource));
            return new ResponseEntity<UserResource>(transformer.convertTo(user, UserRest.class), CREATED);
        } catch (Exception e) {
            return new ResponseEntity<UserResource>(NOT_FOUND);
        }
        //409 (Conflict) if resource already exists..
        //return new ResponseEntity<String>("Unable to create user", headers, CONFLICT);
    }

    @RequestMapping(value = "/{id}", method = PATCH)
    public ResponseEntity<?> update(final Long id, @RequestBody final UserResource userResource) {
        if (userFacadeLayer.update(transformer.convertFrom(userResource))) {
            return responseEntity(OK);
        }
        return responseEntity(NOT_FOUND);
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") final Long id) {
        // 404 (Not Found), unless you want to delete the whole collection—not often desirable.
        // 200 (OK). 404 (Not Found), if ID not found or invalid.
        userFacadeLayer.remove(id);
        return responseEntity(OK);
    }

    private ResponseEntity<?> responseEntity(final HttpStatus status) {
        return new ResponseEntity<>(status);
    }

    private ResponseEntity<UserResource> responseEntity(final UserResource userResource, final HttpStatus status) {
        return new ResponseEntity<>(userResource, status);
    }
}
