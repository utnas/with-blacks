package com.withblacks.facade.user;

import com.withblacks.business.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserFacadeLayer {

    User getUser(final String userName);

    List<User> getUsers();

    User getUser(final Long id);

    User create(final User user);

    boolean update(final User user);

    void remove(final Long id);
}
