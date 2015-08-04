package com.withblacks.rest.user;

import com.withblacks.business.entities.GENDER;

public class UserDtoBuilder {
    private String firstName;
    private String lastName;
    private GENDER gender;

    public UserDto build() {
        final UserDto dto = new UserDto();
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setGender(gender);

        return dto;
    }

    public UserDtoBuilder setFirstName(final String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDtoBuilder setLastName(final String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDtoBuilder setGender(final GENDER gender) {
        this.gender = gender;
        return this;
    }

    public GENDER getGender() {
        return gender;
    }
}
