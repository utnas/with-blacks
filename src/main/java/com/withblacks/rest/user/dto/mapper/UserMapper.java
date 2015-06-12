package com.withblacks.rest.user.dto.mapper;

import com.withblacks.business.entity.User;
import com.withblacks.rest.user.dto.UserResource;

import java.util.List;

public interface UserMapper<F extends User, T extends UserResource> {

    Iterable<T> convertTo(final List<F> sources, final Class<?> aClass);

    T convertTo(final F source, final Class<?> aClass);

    F convertFrom(final T source);
}
