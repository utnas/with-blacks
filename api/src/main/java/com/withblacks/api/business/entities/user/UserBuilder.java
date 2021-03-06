package com.withblacks.api.business.entities.user;

import com.withblacks.api.business.entities.project.Project;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Component
public class UserBuilder {

    private final List<Project> projects = newArrayList();
    private String firstName;
    private String lastName;
    private GENDER gender;
    private Credentials credentials;

    public UserBuilder() {
    }

    public User build() {
        final User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setGender(getGender());
        user.setProjects(projects);
        user.setCredentials(credentials);
        return user;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserBuilder setFirstName(final String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserBuilder setLastName(final String lastName) {
        this.lastName = lastName;
        return this;
    }

    public GENDER getGender() {
        return gender;
    }

    public UserBuilder setGender(final GENDER gender) {
        this.gender = gender;
        return this;
    }

    public UserBuilder addProjects(final Project... projects) {
        Collections.addAll(this.projects, projects);
        return this;
    }

    public UserBuilder setProjects(final List<Project> projects) {
        this.projects.clear();
        this.projects.addAll(projects);
        return this;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public UserBuilder setCredentials(final Credentials credentials) {
        this.credentials = credentials;
        return this;
    }
}
