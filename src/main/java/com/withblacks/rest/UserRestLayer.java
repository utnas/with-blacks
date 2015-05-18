package com.withblacks.rest;

import com.withblacks.business.GENDER;
import com.withblacks.facade.IUserFacadeLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class UserRestLayer implements IUserRestLayer {

    private final IUserFacadeLayer userFacadeLayer;

    @Autowired
    public UserRestLayer(IUserFacadeLayer userFacadeLayer) {
        this.userFacadeLayer = userFacadeLayer;
    }

    @Override
    @RequestMapping(value = "/users/", method = GET)
    public Iterable<UserDto> findAll() {
        Iterable<UserDto> users = userFacadeLayer.getUsers();
        System.out.println(users);
        return users;
    }

    @Override
    @RequestMapping(method = GET)
    public UserDto findByName(@RequestParam final String name) {
        UserDto user = userFacadeLayer.getUser(name);
        System.out.println(user);
        return user;
    }

    @Override
    @RequestMapping(value = "/users/{id}", method = GET)
    public UserDto findById(@RequestParam final long id) {
        UserDto user = userFacadeLayer.getUser(id);
        System.out.println(user);
        return user;
    }

    @Override
    @RequestMapping(method = POST)
    public UserDto create(@RequestParam final String firstName, @RequestParam final String lastName, final GENDER gender) {
        // We should call a transformer instead of using DTO
        UserDto userDto = userFacadeLayer.create(new UserDto(firstName, lastName, gender));
        System.out.println(userDto);
        return userDto;
    }

    @Override
    @RequestMapping(method = PUT)
    public UserDto update(@RequestParam final String firstName, @RequestParam final String lastName, final GENDER gender) {
        // We should call a transformer instead of using DTO
        UserDto userDto = userFacadeLayer.update(new UserDto(firstName, lastName, gender));
        System.out.println(userDto);
        return userDto;
    }

    @Override
    @RequestMapping(method = DELETE)
    public void delete(@RequestParam final long id) {
        userFacadeLayer.remove(id);
        System.out.println("User " + id + " removed");
    }
}
