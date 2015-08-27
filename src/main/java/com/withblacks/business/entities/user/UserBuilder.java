package com.withblacks.business.entities.user;

import com.withblacks.business.entities.project.Project;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Component
public class UserBuilder {

    private String firstName;
    private String lastName;
    private GENDER gender;
    private List<Project> projects = newArrayList();

    public UserBuilder() {
    }

    public static User build(final String firstName, final String lastName, final GENDER gender, final List<Project> projects) {
        final User user = new User();
        user.setGender(gender);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setProjects(projects);
        return user;
    }

    public User build() {
        final User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setGender(getGender());
        user.setProjects(projects);
        return user;
    }

    public UserBuilder setFirstName(final String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserBuilder setLastName(final String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserBuilder setGender(final GENDER gender) {
        this.gender = gender;
        return this;
    }

    public GENDER getGender() {
        return gender;
    }

    public UserBuilder addProject(final Project project) {
        this.projects.add(project);
        return this;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public UserBuilder setProjects(final List<Project> projects) {
        this.projects.clear();
        this.projects.addAll(projects);
        return this;
    }
}
