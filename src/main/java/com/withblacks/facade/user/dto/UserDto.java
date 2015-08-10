package com.withblacks.facade.user.dto;

import com.withblacks.business.entities.user.GENDER;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public GENDER getGender() {
        return gender;
    }

    public void setGender(final GENDER gender) {
        this.gender = gender;
    }

    public void setId(long id) {
        this.id = id;
    }
}
