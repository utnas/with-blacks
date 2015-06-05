package com.withblacks.rest.user;

import com.withblacks.business.entity.User;
import com.withblacks.facade.user.IUserFacadeLayer;
import com.withblacks.rest.user.trasformer.IUserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping(value = "/users")
public class UserRestLayer implements IUserRestLayer {

    private IUserFacadeLayer userFacadeLayer;
    private IUserTransformer<User, UserDto> transformer;

    public UserRestLayer() {
    }

    @Autowired
    public UserRestLayer(IUserFacadeLayer userFacadeLayer, IUserTransformer<User, UserDto> transformer) {
        this.userFacadeLayer = userFacadeLayer;
        this.transformer = transformer;
    }

    @RequestMapping(method = GET)
    @ResponseBody
    public Iterable findAll() {
        return transformer.convertTo(
                userFacadeLayer.getUsers()
        );
    }

    @RequestMapping(value = "/{id}", method = GET)
    @ResponseBody
    public ResponseEntity<?> findById(@PathVariable("id") final String id) {
        final UserDto userDto = transformer.convertTo(
                userFacadeLayer.getUser(id)
        );
        return userDto == null ? responseEntity(NOT_FOUND) : responseEntity(userDto, OK);
    }

    @RequestMapping(method = POST)
    @ResponseStatus(CREATED)
    public ResponseEntity<?> create(@RequestBody final UserDto userDto, HttpServletRequest request, HttpServletResponse response) {
        User user = userFacadeLayer.create(
                transformer.convertFrom(userDto)
        );
        response.setHeader("Location", request.getRequestURL().append("/").append(user.getId()).toString());
        return responseEntity(OK);
    }

    @RequestMapping(value = "/{id}", method = PATCH)
    @ResponseStatus(OK)
    public boolean update(@RequestBody final UserDto userDto) {
        return userFacadeLayer.update(
                transformer.convertFrom(userDto)
        );
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public void delete(@RequestParam final long id) {
        userFacadeLayer.remove(id);
    }

    private ResponseEntity<Object> responseEntity(final HttpStatus status) {
        return new ResponseEntity<>(status);
    }

    private ResponseEntity<UserDto> responseEntity(final UserDto userDto, final HttpStatus status) {
        return new ResponseEntity<>(userDto, status);
    }
}
