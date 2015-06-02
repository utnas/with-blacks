package com.withblacks.rest.user.trasformer;

import com.withblacks.business.entity.User;
import com.withblacks.rest.user.UserDto;

import java.util.List;

public interface IUserTransformer<F extends User, T extends UserDto> {

    Iterable<T> convertTo(final List<F> sources);

    T convertTo(final F source);

    F convertFrom(final T source);
}
