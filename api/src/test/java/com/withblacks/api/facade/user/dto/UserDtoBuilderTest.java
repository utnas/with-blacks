package com.withblacks.api.facade.user.dto;

import com.withblacks.api.business.entities.user.GENDER;
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

        final UserDto dto = builder.build();

        assertThat(dto.getFirstName(), is("Iron"));
        assertThat(dto.getLastName(), is("Man"));
        assertThat(dto.getGender(), is(GENDER.MALE));
    }
}