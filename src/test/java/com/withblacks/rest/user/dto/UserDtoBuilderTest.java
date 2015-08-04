package com.withblacks.rest.user.dto;

import com.withblacks.business.entities.GENDER;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserDtoBuilderTest {

    @Test
    public void itShouldSetFistNameOfUserDto() {
        final UserDtoBuilder dtoBuilder = new UserDtoBuilder();

        assertThat(dtoBuilder.setFirstName("NewFirstName").getFirstName(), is("NewFirstName"));
    }

    @Test
    public void itShouldSetLastNameOfUserDto() {
        final UserDtoBuilder dtoBuilder = new UserDtoBuilder();

        assertThat(dtoBuilder.setLastName("NewLastName").getLastName(), is("NewLastName"));
    }

    @Test
    public void itShouldSetGenderOfUserDto() {
        final UserDtoBuilder dtoBuilder = new UserDtoBuilder();

        assertThat(dtoBuilder.setGender(GENDER.FEMALE).getGender(), is(GENDER.FEMALE));
    }

    @Test
    public void itShouldBuildAUSerDto() {

        final UserDtoBuilder builder = new UserDtoBuilder();

        builder.setFirstName("Iron").setLastName("Man").setGender(GENDER.MALE);

        assertThat(builder.build().getFirstName(), is("Iron"));
        assertThat(builder.build().getLastName(), is("Man"));
        assertThat(builder.build().getGender(), is(GENDER.MALE));
    }
}