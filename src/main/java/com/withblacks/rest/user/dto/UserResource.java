package com.withblacks.rest.user.dto;

import com.withblacks.business.entity.GENDER;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Component;

@Component
public class UserResource extends ResourceSupport {

    private long id;
    private String firstName;
    private String lastName;
    private GENDER gender;

    public UserResource() {
    }

    public UserResource(final long id, final String firstName, final String lastName, final GENDER gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public UserResource(final String firstName, final String lastName, final GENDER gender) {
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

    public Long getIds() {
        return id;
    }
}
