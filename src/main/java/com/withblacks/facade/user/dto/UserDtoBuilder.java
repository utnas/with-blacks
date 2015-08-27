package com.withblacks.facade.user.dto;

import com.withblacks.business.entities.project.Project;
import com.withblacks.business.entities.user.GENDER;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class UserDtoBuilder {
    private String firstName;
    private String lastName;
    private GENDER gender;
    private List<Project> projects = newArrayList();

    public UserDto build() {
        final UserDto dto = new UserDto();
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setGender(gender);
        dto.setProjects(projects);

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

    public List<Project> getProjects() {
        return projects;
    }

    public UserDtoBuilder setProjects(final List<Project> projects) {
        this.projects.clear();
        this.projects.addAll(projects);
        return this;
    }
}
