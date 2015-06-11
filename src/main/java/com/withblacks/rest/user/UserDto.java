package com.withblacks.rest.user;

import com.withblacks.business.entity.GENDER;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Component;

@Component
public class UserDto extends ResourceSupport {

    private long id;
    private String firstName;
    private String lastName;
    private GENDER gender;

    public UserDto() {
    }

    public UserDto(final long id, final String firstName, final String lastName, final GENDER gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public UserDto(final String firstName, final String lastName, final GENDER gender) {
        this.id = -1;
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

    public Long getLocalId() {
        return id;
    }
}
