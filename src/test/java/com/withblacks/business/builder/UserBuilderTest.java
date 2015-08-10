package com.withblacks.business.builder;

import com.withblacks.business.entities.user.User;
import com.withblacks.business.entities.user.UserBuilder;
import org.junit.Before;
import org.junit.Test;

import static com.withblacks.business.entities.user.GENDER.MALE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserBuilderTest {

    private UserBuilder builder;

    @Before
    public void setUp() {
        builder = new UserBuilder();
    }

    @Test
    public void itShouldSetFirstName() {
        assertThat(builder.setFirstName("Iron").getFirstName(), is("Iron"));
    }

    @Test
    public void itShouldSetLastName() {
        assertThat(builder.setLastName("Man").getLastName(), is("Man"));
    }

    @Test
    public void itShouldSetGender() {
        assertThat(builder.setGender(MALE).getGender(), is(MALE));
    }

    @Test
    public void itShouldBuildUser() {
        builder.setFirstName("Iron")
                .setLastName("Man")
                .setGender(MALE);
        User user = builder.build();

        assertThat(user.getFirstName(), is("Iron"));
        assertThat(user.getLastName(), is("Man"));
        assertThat(user.getGender(), is(MALE));
    }
}