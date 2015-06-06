package com.withblacks.rest.user;

import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

interface IUserRestLayer {

    Iterable findAll();

    ResponseEntity<?> findById(final Long id);

    ResponseEntity<?> create(final UserDto userDto, HttpServletRequest request, HttpServletResponse response);

    ResponseEntity<?> update(final Long id, final UserDto userDto);

    void delete(final Long id);
}