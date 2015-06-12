package com.withblacks.rest.user.trasformer;

import com.withblacks.business.entity.GENDER;
import com.withblacks.rest.user.UserResource;

public class UserDtoBuilder {

    public static UserResource build(final long id, final String firstName, final String lastName, final GENDER gender) {
        // catch errors here
        return new UserResource(id, firstName, lastName, gender);
    }

    public static UserResource build(final String firstName, final String lastName, final GENDER gender) {
        // catch errors here
        return new UserResource(firstName, lastName, gender);
    }
}
