package com.withblacks.rest.user.trasformer;

import com.google.common.base.Function;
import com.withblacks.business.User;
import com.withblacks.rest.user.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Component
public class UserDtoTransformer implements IUserDtoTransformer {

    public UserDtoTransformer() {
    }

    @Override
    public Iterable<UserDto> transform(List<User> users) {
        return new Function<List<User>, Iterable<UserDto>>() {
            public Iterable<UserDto> apply(List<User> userList) {
                List<UserDto> result = newArrayList();
                for (User user : userList) {
                    result.add(transform(user));
                }
                return result;
            }
        }.apply(users);
    }

    @Override
    public UserDto transform(final User user) {
        return new Function<User, UserDto>() {
            public UserDto apply(final User input) {
                return new UserDto(user.getFirstName(), user.getLastName(), user.getGender());
            }
        }.apply(user);
    }

    @Override
    public User transform(final UserDto userDto) {
        return new Function<UserDto, User>() {
            public User apply(UserDto input) {
                return new User(input.getFirstName(), input.getLastName(), input.getGender());
            }
        }.apply(userDto);
    }
}
