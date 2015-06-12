package com.withblacks.rest.user.trasformer;

import com.google.common.base.Function;
import com.withblacks.business.builder.UserBuilder;
import com.withblacks.business.entity.User;
import com.withblacks.rest.user.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Arrays.asList;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class UserTransformer implements IUserTransformer<User, UserDto> {

    public UserTransformer() {
    }

    @Override
    public Iterable<UserDto> convertTo(final List<User> users, final Class<?>... klass) {
        return toDtoList(users, asList(klass).get(0));
    }

    @Override
    public UserDto convertTo(final User user, final Class<?>... klass) {
        final UserDto dto = toDto(user);
        final Class<?> aClass = asList(klass).get(0);
        dto.add(linkTo(aClass).slash(user.getId()).withSelfRel());

        return dto;
    }

    @Override
    public User convertFrom(final UserDto userDto) {
        return toUser(userDto);
    }

    private User toUser(final UserDto userDto) {
        return new Function<UserDto, User>() {
            public User apply(final UserDto input) {
                return UserBuilder.build(input.getLocalId(), input.getFirstName(), input.getLastName(), input.getGender());
            }
        }.apply(userDto);
    }

    private UserDto toDto(final User user) {
        return new Function<User, UserDto>() {
            public UserDto apply(final User input) {
                return UserDtoBuilder.build(input.getId(), input.getFirstName(), input.getLastName(), input.getGender());
            }
        }.apply(user);
    }

    private Iterable<UserDto> toDtoList(final List<User> users, final Class<?> aClass) {
        return new Function<List<User>, Iterable<UserDto>>() {
            public Iterable<UserDto> apply(final List<User> input) {
                List<UserDto> result = newArrayList();
                for (final User user : input) {
                    result.add(convertTo(user, aClass));
                }
                return result;
            }
        }.apply(users);
    }
}
