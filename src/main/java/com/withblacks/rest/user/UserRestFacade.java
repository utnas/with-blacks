package com.withblacks.rest.user;

import com.withblacks.business.entity.User;
import com.withblacks.facade.user.IUserFacadeLayer;
import com.withblacks.rest.user.trasformer.IUserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.NoSuchElementException;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/users")
public class UserRestFacade implements IUserRestFacade {

    private IUserFacadeLayer userFacadeLayer;
    private IUserTransformer<User, UserDto> transformer;

    public UserRestFacade() {
    }

    @Autowired
    public UserRestFacade(IUserFacadeLayer userFacadeLayer, IUserTransformer<User, UserDto> transformer) {
        this.userFacadeLayer = userFacadeLayer;
        this.transformer = transformer;
    }

    @RequestMapping(method = GET)
    public Iterable findAll() {
        // 200 (OK), single customer
        return transformer.convertTo(userFacadeLayer.getUsers());
    }

    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<UserDto> findById(@PathVariable("id") final Long id) {
        // 200 (OK), list of customers. Use pagination, sorting and filtering to navigate big lists.
        // 200 (OK), single customer. 404 (Not Found), if ID not found or invalid.
        final UserDto userDto;
        try {
            userDto = transformer.convertTo(userFacadeLayer.getUser(id));
        } catch (NoSuchElementException e) {
            return new ResponseEntity<UserDto>(NOT_FOUND);
        }
        Link link = linkTo(UserRestFacade.class).slash(userDto.getLocalId()).withSelfRel();
        userDto.add(link);
        return new ResponseEntity<UserDto>(userDto, OK);
    }

    @RequestMapping(method = POST)
    public ResponseEntity<String> create(@RequestBody final UserDto userDto, HttpServletRequest request, HttpServletResponse response) {
        //201 (Created), 'Location' header with link to /customers/{id} containing new ID.
        User user = userFacadeLayer.create(transformer.convertFrom(userDto));
        if (user != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(linkTo(UserRestFacade.class).slash(user.getId()).toUri());
            return new ResponseEntity<String>(user.getId().toString(), headers, HttpStatus.CREATED);
        }
        //409 (Conflict) if resource already exists..
        //return new ResponseEntity<String>("Unable to create user", headers, CONFLICT);
        //404 (Not Found)
        return new ResponseEntity<String>("Unable to create user", NOT_FOUND);
    }

    @RequestMapping(value = "/{id}", method = PATCH)
    public ResponseEntity<?> update(final Long id, @RequestBody final UserDto userDto) {
        if (userFacadeLayer.update(transformer.convertFrom(userDto))) {
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

    private ResponseEntity<UserDto> responseEntity(final UserDto userDto, final HttpStatus status) {
        return new ResponseEntity<>(userDto, status);
    }
}
