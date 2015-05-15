package com.withblacks.rest;

import com.withblacks.business.GENDER;

public class UserDto {

    private String firstName;
    private String lastName;
    private GENDER gender;

    public UserDto() {
    }

    public UserDto(final String firstName, final String lastName, final GENDER gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public final GENDER getGender() {
        return gender;
    }

    public void setGender(final GENDER gender) {
        this.gender = gender;
    }
}
