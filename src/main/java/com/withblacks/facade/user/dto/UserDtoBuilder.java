package com.withblacks.facade.user.dto;

import com.withblacks.business.entities.user.GENDER;
import com.withblacks.facade.project.dto.ProjectDto;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class UserDtoBuilder {
    private String firstName;
    private String lastName;
    private GENDER gender;
    private final List<ProjectDto> projects = newArrayList();

    public UserDto build() {
        final UserDto dto = new UserDto();
        dto.setFirstName(firstName);
        dto.setLastName(lastName);
        dto.setGender(gender);
        dto.setProjects(projects);
        return dto;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDtoBuilder setFirstName(final String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDtoBuilder setLastName(final String lastName) {
        this.lastName = lastName;
        return this;
    }

    public GENDER getGender() {
        return gender;
    }

    public UserDtoBuilder setGender(final GENDER gender) {
        this.gender = gender;
        return this;
    }

    public List<ProjectDto> getProjects() {
        return projects;
    }

    public UserDtoBuilder setProjects(final List<ProjectDto> projects) {
        this.projects.clear();
        this.projects.addAll(projects);
        return this;
    }
}
