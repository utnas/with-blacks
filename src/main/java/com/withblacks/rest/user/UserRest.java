package com.withblacks.rest.user;

import com.withblacks.facade.user.UserFacade;
import com.withblacks.facade.user.dto.UserDto;
import com.withblacks.rest.RestLayer;
import com.withblacks.rest.toolbox.RestActionResponse;
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
@PropertySource("classpath:version.properties")
@RequestMapping(value = "{@Value(\"${spring.rest.version}\")}/users")
public class UserRest implements RestLayer<UserDto> {

    @Autowired
    private RestActionResponse actionResponse;
    private UserFacade facade;

    @Value("${spring.rest.version}")
    private String apiRevision;

    @Autowired
    public UserRest(final UserFacade facade, final RestActionResponse actionResponse) {
        this.facade = facade;
        this.actionResponse = actionResponse;
    }

    @RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(facade.getAll(), OK);
    }

    @RequestMapping(value = "/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findById(@PathVariable("id") final Long id) {
        try {
            return new ResponseEntity<>(facade.getOne(id), OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity(NOT_FOUND);
        } catch (NullPointerException e) {
            return new ResponseEntity(NOT_FOUND);
        }
    }

    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody final UserDto userDto) {
        try {
            return new ResponseEntity<>(facade.create(userDto), CREATED);
        } catch (NoSuchElementException e) {
            return new ResponseEntity(CONFLICT);
        }
    }

    @RequestMapping(value = "/{id}", method = PATCH, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> patch(@PathVariable("id") final Long id, @RequestBody final UserDto resource) {
        return actionResponse.updateEntity(id, resource);
    }

    @RequestMapping(value = "/{id}", method = PUT, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable("id") final Long id, @RequestBody final UserDto resource) {
        return actionResponse.updateEntity(id, resource);
    }

    @Override
    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") final Long id) {
        return actionResponse.deleteEntity(id);
    }
}
