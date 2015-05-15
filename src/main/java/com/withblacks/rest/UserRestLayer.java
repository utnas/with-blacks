package com.withblacks.rest;

import com.withblacks.business.GENDER;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Collections.EMPTY_LIST;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class UserRestLayer {

    @RequestMapping(value = "/users/", method = GET)
    public List findAll() {
        return newArrayList(new UserDto());
    }

    @RequestMapping(method = GET)
    public Iterable<UserDto> findByName(@RequestParam final String name) {
        return EMPTY_LIST;
    }

    @RequestMapping(value = "/users/{id}", method = GET)
    public UserDto findById(@RequestParam final long id) {
        return new UserDto();
    }

    @RequestMapping(method = POST)
    public UserDto create(@RequestParam final String firstName, @RequestParam final String lastName, final GENDER gender) {
        return new UserDto();
    }

    @RequestMapping(method = PUT)
    public UserDto update(@RequestParam final String firstName, @RequestParam final String lastName, final GENDER gender) {
        return new UserDto();
    }

    @RequestMapping(method = DELETE)
    public String delete(@RequestParam final long id) {
        return "200";
    }
}
