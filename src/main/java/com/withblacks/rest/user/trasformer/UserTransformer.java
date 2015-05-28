package com.withblacks.rest.user.trasformer;

import com.google.common.base.Function;
import com.withblacks.business.builder.UserBuilder;
import com.withblacks.business.entity.User;
import com.withblacks.rest.user.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Component
public class UserTransformer implements IUserTransformer {

    public UserTransformer() {
    }

    @Override
    public Iterable<UserDto> toDtos(final List<User> users) {
        return new Function<List<User>, Iterable<UserDto>>() {
            public Iterable<UserDto> apply(final List<User> userList) {
                List<UserDto> result = newArrayList();
                for (final User user : userList) {
                    result.add(toDto(user));
                }
                return result;
            }
        }.apply(users);
    }

    @Override
    public UserDto toDto(final User user) {
        return new Function<User, UserDto>() {
            public UserDto apply(final User input) {
                return UserDtoBuilder.build(user.getFirstName(), user.getLastName(), user.getGender());
            }
        }.apply(user);
    }

    @Override
    public User toUser(final UserDto userDto) {
        return new Function<UserDto, User>() {
            public User apply(final UserDto input) {
                return UserBuilder.build(input.getFirstName(), input.getLastName(), input.getGender());
            }
        }.apply(userDto);
    }
}
