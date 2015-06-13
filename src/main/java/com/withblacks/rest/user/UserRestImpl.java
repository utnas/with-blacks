package com.withblacks.rest.user;

import com.withblacks.business.entity.User;
import com.withblacks.facade.user.UserFacadeLayer;
import com.withblacks.rest.user.dto.UserResource;
import com.withblacks.rest.user.dto.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

import static java.util.Optional.of;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/users")
public class UserRestImpl implements UserRest {

    private UserFacadeLayer userFacadeLayer;
    private UserMapper<User, UserResource> transformer;

    public UserRestImpl() {
    }

    @Autowired
    public UserRestImpl(UserFacadeLayer userFacadeLayer, UserMapper<User, UserResource> transformer) {
        this.userFacadeLayer = userFacadeLayer;
        this.transformer = transformer;
    }

    @RequestMapping(method = GET)
    public ResponseEntity<?> findAll() {
        final Iterable<UserResource> userDtoList = transformer.convertTo(userFacadeLayer.getUsers(), of(UserRestImpl.class));
        return new ResponseEntity<Iterable>(userDtoList, OK);
    }

    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<UserResource> findById(@PathVariable("id") final Long id) {
        try {
            final UserResource userResource = transformer.convertTo(userFacadeLayer.getUser(id), of(UserRestImpl.class));
            return new ResponseEntity<UserResource>(userResource, OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<UserResource>(NOT_FOUND);
        }
    }

    @RequestMapping(method = POST)
    public ResponseEntity<UserResource> create(@RequestBody final UserResource userResource) {
        try {
            final User user = userFacadeLayer.create(transformer.convertFrom(userResource));
            return new ResponseEntity<UserResource>(transformer.convertTo(user, of(UserRestImpl.class)), CREATED);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<UserResource>(CONFLICT);
        }
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
        try {
            userFacadeLayer.remove(id);
            return responseEntity(OK);
        } catch (NoSuchElementException e) {
            return responseEntity(NOT_FOUND);
        }
    }

    private ResponseEntity<?> responseEntity(final HttpStatus status) {
        return new ResponseEntity<>(status);
    }
}
