package com.withblacks.business.entities;

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