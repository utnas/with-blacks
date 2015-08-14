package com.withblacks.facade.user;

import com.withblacks.facade.EntityFacade;
import com.withblacks.facade.user.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public interface UserFacade extends EntityFacade<UserDto> {
}
