package com.withblacks.api.facade.user.dto;

import com.withblacks.api.business.entities.user.Credentials;
import com.withblacks.api.business.entities.user.GENDER;
import com.withblacks.api.facade.EntityDto;
import com.withblacks.api.facade.project.dto.ProjectDto;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Component
public class UserDto extends ResourceSupport implements EntityDto {

    private final List<ProjectDto> projects = newArrayList();
    private long id;
    private String firstName;
    private String lastName;
    private GENDER gender;
    private Credentials credentials;

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

    public List<ProjectDto> getProjects() {
        return projects;
    }

    public void setProjects(final List<ProjectDto> projects) {
        this.projects.addAll(projects);
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(final Credentials credentials) {
        this.credentials = credentials;
    }
}
