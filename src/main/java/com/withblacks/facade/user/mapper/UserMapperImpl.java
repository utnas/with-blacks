package com.withblacks.facade.user.mapper;

import com.google.common.base.Function;
import com.withblacks.business.builder.UserBuilder;
import com.withblacks.business.entity.User;
import com.withblacks.rest.user.dto.UserResource;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Component
public class UserMapperImpl implements UserMapper<User, UserResource> {

    public UserMapperImpl() {
    }

    @Override
    public Iterable<UserResource> convertTo(final List<User> users) {
        return toDtoList(users);
    }

    @Override
    public UserResource convertTo(final User user) {
        return toDto(user);
    }

    @Override
    public User convertFrom(final UserResource userResource) {
        return toUser(userResource);
    }

    private User toUser(final UserResource userResource) {
        return new Function<UserResource, User>() {
            public User apply(final UserResource input) {
                return UserBuilder.build(input.getIds(), input.getFirstName(), input.getLastName(), input.getGender());
            }
        }.apply(userResource);
    }

    private UserResource toDto(final User user) {
        return new Function<User, UserResource>() {
            public UserResource apply(final User input) {
                return UserResourceBuilder.build(input.getId(), input.getFirstName(), input.getLastName(), input.getGender());
            }
        }.apply(user);
    }

    private Iterable<UserResource> toDtoList(final List<User> users) {
        return new Function<List<User>, Iterable<UserResource>>() {
            public Iterable<UserResource> apply(final List<User> input) {
                List<UserResource> result = newArrayList();
                for (final User user : input) {
                    result.add(convertTo(user));
                }
                return result;
            }
        }.apply(users);
    }
}
