package com.withblacks.rest.user.dto.mapper;

import com.google.common.base.Function;
import com.withblacks.business.builder.UserBuilder;
import com.withblacks.business.entity.User;
import com.withblacks.rest.user.dto.UserResource;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class UserMapperImpl implements UserMapper<User, UserResource> {

    public UserMapperImpl() {
    }

    @Override
    public Iterable<UserResource> convertTo(final List<User> users, final Class<?> aClass) {
        return toDtoList(users, aClass);
    }

    @Override
    public UserResource convertTo(final User user, final Class<?> aClass) {
        final UserResource resource = toDto(user);
        resource.add(linkTo(aClass).slash(user.getId()).withSelfRel());
        return resource;
    }

    @Override
    public User convertFrom(final UserResource userResource) {
        return toUser(userResource);
    }

    private User toUser(final UserResource userResource) {
        return new Function<UserResource, User>() {
            public User apply(final UserResource input) {
                return UserBuilder.build(input.getLocalId(), input.getFirstName(), input.getLastName(), input.getGender());
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

    private Iterable<UserResource> toDtoList(final List<User> users, final Class<?> aClass) {
        return new Function<List<User>, Iterable<UserResource>>() {
            public Iterable<UserResource> apply(final List<User> input) {
                List<UserResource> result = newArrayList();
                for (final User user : input) {
                    result.add(convertTo(user, aClass));
                }
                return result;
            }
        }.apply(users);
    }
}
