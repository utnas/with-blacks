package com.withblacks.rest.user.dto.mapper;

import com.withblacks.business.entity.GENDER;
import com.withblacks.rest.user.dto.UserResource;

public class UserResourceBuilder {

    public static UserResource build(final long id, final String firstName, final String lastName, final GENDER gender) {
        // catch errors here
        return new UserResource(id, firstName, lastName, gender);
    }

    public static UserResource build(final String firstName, final String lastName, final GENDER gender) {
        // catch errors here
        return new UserResource(firstName, lastName, gender);
    }
}
