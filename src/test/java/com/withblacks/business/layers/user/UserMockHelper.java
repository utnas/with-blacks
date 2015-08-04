package com.withblacks.business.layers.user;

import com.withblacks.business.entities.GENDER;
import com.withblacks.business.entities.User;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserMockHelper {

    public static User mockUser(final String firstName, final String lastName, final GENDER gender) {
        final User user = mock(User.class);

        when(user.getFirstName()).thenReturn(firstName);
        when(user.getLastName()).thenReturn(lastName);
        when(user.getGender()).thenReturn(gender);

        return user;
    }
}
