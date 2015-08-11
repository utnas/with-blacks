package com.withblacks.rest.user;

import com.withblacks.facade.user.UserFacadeLayer;
import com.withblacks.facade.user.dto.UserDto;
import com.withblacks.rest.RestLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
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
@PropertySource("classpath:application.properties")
@RequestMapping(value = "/users")
public class UserRest implements RestLayer<UserDto> {

    private final UserFacadeLayer userFacadeLayer;
    @Value("${spring.rest.version}")
    private String apiRevision;

    @Autowired
    public UserRest(final UserFacadeLayer userFacadeLayer) {
        this.userFacadeLayer = userFacadeLayer;
    }

    @RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(userFacadeLayer.getUsers(), OK);
    }

    @RequestMapping(value = "{apiRevision}/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findById(@PathVariable("id") final Long id) {
        try {
            return new ResponseEntity<>(userFacadeLayer.getUser(id), OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity(NOT_FOUND);
        } catch (NullPointerException e) {
            return new ResponseEntity(NOT_FOUND);
        }
    }

    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody final UserDto userDto) {
        try {
            return new ResponseEntity<>(userFacadeLayer.create(userDto), CREATED);
        } catch (NoSuchElementException e) {
            return new ResponseEntity(CONFLICT);
        }
    }

    @RequestMapping(value = "{apiRevision}/{id}", method = PATCH, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> patch(@PathVariable("id") final Long id, @RequestBody final UserDto userDto) {
        try {
            return new ResponseEntity<>(userFacadeLayer.update(id, userDto), OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity(NOT_FOUND);
        } catch (ClassCastException e) {
            return new ResponseEntity(NOT_ACCEPTABLE);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(BAD_REQUEST);
        }
    }

    @RequestMapping(value = "{apiRevision}/{id}", method = PUT, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable("id") final Long id, @RequestBody final UserDto resource) {
        try {
            return new ResponseEntity<>(userFacadeLayer.update(id, resource), OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity(NOT_FOUND);
        }
    }

    @Override
    @RequestMapping(value = "{apiRevision}/{id}", method = DELETE)
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
