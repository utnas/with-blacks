package com.withblacks.facade;

import com.withblacks.business.User;
import com.withblacks.rest.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IUserFacadeLayer {

    User getUser(final String userName);

    List<User> getUsers();

    User getUser(final long id);

    User create(final User userDto);

    User update(final User userDto);

    void remove(final long id);
}
