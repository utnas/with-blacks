package com.withblacks.business.builder;

import com.withblacks.business.entities.Project;

public class ProjectBuilder {
    private String name;

    public ProjectBuilder setName(final String name) {
        this.name = name;
        return this;
    }

    public Project build() {
        final Project project = new Project();
        project.setName(name);

        return project;
    }
}