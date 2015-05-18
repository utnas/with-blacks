package com.withblacks.facade.user;

import com.withblacks.business.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IUserFacadeLayer {

    User getUser(final String userName);

    List<User> getUsers();

    User getUser(final long id);

    boolean create(final User userDto);

    User update(final User userDto);

    void remove(final long id);
}
