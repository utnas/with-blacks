package com.withblacks.facade.user;

import com.withblacks.rest.user.dto.UserResource;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public interface UserFacadeLayer {

    UserResource getUser(final String userName);

    Iterable<UserResource> getUsers();

    UserResource getUser(final Long id) throws NoSuchElementException;

    UserResource create(final UserResource userResource) throws NoSuchElementException;

    boolean update(final Long id, final UserResource userResource) throws NoSuchElementException, ClassCastException, IllegalArgumentException;

    void remove(final Long id) throws NoSuchElementException;
}
