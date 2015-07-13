package com.withblacks.facade.user.mapper;

import com.withblacks.business.entity.User;
import com.withblacks.rest.user.dto.UserResource;

import java.util.Collection;

public interface UserMapper<F extends User, T extends UserResource> {

    Iterable<T> convertTo(final Collection<F> sources);

    T convertTo(final F source);

    F convertFrom(final T source);
}
