package com.withblacks.rest.user.trasformer;

import com.withblacks.business.entity.User;
import com.withblacks.rest.user.UserDto;

import java.util.List;

public interface IUserTransformer<F extends User, T extends UserDto> {

    Iterable<T> convertTo(final List<F> sources, final Class<?>... klass);

    T convertTo(final F source, final Class<?>... klass);

    F convertFrom(final T source);
}
