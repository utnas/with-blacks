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
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/users")
public class UserRestImpl implements UserRest {

    private final transient UserFacadeLayer userFacadeLayer;
    private final transient UserMapper<User, UserResource> transformer;

    @Autowired
    public UserRestImpl(final UserFacadeLayer userFacadeLayer, final UserMapper<User, UserResource> transformer) {
        this.userFacadeLayer = userFacadeLayer;
        this.transformer = transformer;
    }

    @RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {
        final Iterable<UserResource> userDtoList = transformer.convertTo(userFacadeLayer.getUsers(), of(UserRestImpl.class));
        return responseEntity(userDtoList, OK);
    }

    @RequestMapping(value = "/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findById(@PathVariable("id") final Long id) {
        try {
            final User user = userFacadeLayer.getUser(id);
            return responseEntity(transformer.convertTo(user, of(UserRestImpl.class)), OK);

        } catch (NoSuchElementException e) {
            return responseEntity(NOT_FOUND);
        }
    }

    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody final UserResource userResource) {
        try {
            final User user = userFacadeLayer.create(transformer.convertFrom(userResource));
            return responseEntity(transformer.convertTo(user, of(UserRestImpl.class)), CREATED);

        } catch (Throwable e) {
            return responseEntity(CONFLICT);
        }
    }

    @RequestMapping(value = "/{id}", method = PATCH, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(final Long id, @RequestBody final UserResource userResource) {
        try {
            final User user = transformer.convertFrom(userResource);
            userFacadeLayer.update(user);
            return responseEntity(transformer.convertTo(user, of(UserRestImpl.class)), OK);

        } catch (NoSuchElementException e) {
            return responseEntity(NOT_FOUND);
        } catch (ClassCastException e) {
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
