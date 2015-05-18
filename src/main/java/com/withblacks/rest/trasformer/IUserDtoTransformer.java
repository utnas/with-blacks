package com.withblacks.rest.trasformer;

import com.withblacks.business.User;
import com.withblacks.rest.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;

public interface IUserDtoTransformer {

    Iterable<UserDto> transform(List<User> users);

    UserDto transform(User users);
}
