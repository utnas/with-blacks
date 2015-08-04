package com.withblacks.rest.user;

import com.withblacks.business.entities.GENDER;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserDtoTest {

    private UserDto dto;

    @Before
    public void setUp() throws Exception {
        dto = new UserDtoBuilder()
                .setFirstName("Iron")
                .setLastName("Man")
                .setGender(GENDER.MALE)
                .build();
    }

    @Test
    public void itShouldGetFirstName() throws Exception {
        assertThat(dto.getFirstName(), is("Iron"));
    }

    @Test
    public void itShouldSetFirstName() throws Exception {
        dto.setFirstName("Super");
        assertThat(dto.getFirstName(), is("Super"));
    }

    @Test
    public void itShouldGetLastName() throws Exception {
        assertThat(dto.getLastName(), is("Man"));
    }

    @Test
    public void itShouldSetLastName() throws Exception {
        dto.setLastName("Woman");
        assertThat(dto.getLastName(), is("Woman"));
    }

    @Test
    public void testGetGender() throws Exception {
        assertThat(dto.getGender(), is(GENDER.MALE));
    }

    @Test
    public void itShouldSetGender() throws Exception {
        dto.setGender(GENDER.FEMALE);
        assertThat(dto.getGender(), is(GENDER.FEMALE));
    }
}