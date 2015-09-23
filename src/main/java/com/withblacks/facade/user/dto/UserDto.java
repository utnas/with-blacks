package com.withblacks.facade.user.dto;

import com.withblacks.business.entities.user.GENDER;
import com.withblacks.facade.EntityDto;
import com.withblacks.facade.project.dto.ProjectDto;
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
}
