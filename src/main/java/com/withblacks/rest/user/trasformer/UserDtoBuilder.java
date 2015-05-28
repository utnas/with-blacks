package com.withblacks.rest.user.trasformer;

import com.withblacks.business.entity.GENDER;
import com.withblacks.rest.user.UserDto;

public class UserDtoBuilder {

    public static UserDto build(final String firstName, final String lastName, final GENDER gender) {
        // catch errors here
        return new UserDto(firstName, lastName, gender);
    }
}
