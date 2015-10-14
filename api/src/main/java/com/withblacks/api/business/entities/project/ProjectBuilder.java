package com.withblacks.api.business.entities.project;

import com.withblacks.api.business.entities.user.User;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class ProjectBuilder {
    private final List<User> members = newArrayList();
    private String name;

    public ProjectBuilder setName(final String name) {
        this.name = name;
        return this;
    }

    public Project build() {
        final Project project = new Project();
        project.setName(name);
        project.addMembers(members);

        return project;
    }

    public ProjectBuilder addMember(final User member) {
        members.add(member);
        return this;
    }

    public ProjectBuilder addMembers(final List<User> members) {
        this.members.addAll(members);
        return this;
    }
}