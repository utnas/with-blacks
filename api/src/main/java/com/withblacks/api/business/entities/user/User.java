package com.withblacks.api.business.entities.user;

import com.withblacks.api.business.entities.project.Project;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Component
@Entity
@Table(name = "Users")
@Data
public class User {

    private static final long serialVersionUID = -2952735933715107252L;
    @OneToMany
    private final List<Project> projects = newArrayList();
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private GENDER gender;

    @OneToOne
    private Credentials credentials;

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public GENDER getGender() {
        return gender;
    }

    public void setGender(final GENDER gender) {
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(final List<Project> projects) {
        this.projects.clear();
        this.projects.addAll(projects);
    }

    public boolean addOneProject(final Project project) {
        return projects.add(project);
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(final Credentials credentials) {
        this.credentials = credentials;
    }

    public void setCredentials(final String login, final String password) {
        this.credentials = new Credentials(login, password);
    }
}
