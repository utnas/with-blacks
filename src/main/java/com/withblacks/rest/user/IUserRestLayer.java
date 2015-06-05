package com.withblacks.rest.user;

import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

interface IUserRestLayer {

    Iterable findAll();

    ResponseEntity<?> findById(final String id);

    ResponseEntity<?> create(final UserDto userDto, HttpServletRequest request, HttpServletResponse response);

    boolean update(final UserDto userDto);

    void delete(final long id);
}