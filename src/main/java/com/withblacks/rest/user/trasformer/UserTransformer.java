package com.withblacks.rest.user.trasformer;

import com.withblacks.business.entity.User;
import com.withblacks.rest.user.UserResource;

import java.util.List;

public interface UserTransformer<F extends User, T extends UserResource> {

    Iterable<T> convertTo(final List<F> sources, final Class<?>... klass);

    T convertTo(final F source, final Class<?>... klass);

    F convertFrom(final T source);
}
