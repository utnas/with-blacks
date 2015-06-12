package com.withblacks.rest.user.dto.mapper;

import com.withblacks.business.entity.User;
import com.withblacks.rest.user.dto.UserResource;

import java.util.List;
import java.util.Optional;

public interface UserMapper<F extends User, T extends UserResource> {

    Iterable<T> convertTo(final List<F> sources, final Optional<Class<?>> aClass);

    T convertTo(final F source, final Optional<Class<?>> aClass);

    F convertFrom(final T source);
}
