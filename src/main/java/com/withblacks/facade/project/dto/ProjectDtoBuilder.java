package com.withblacks.facade.project.dto;

import org.springframework.stereotype.Component;

@Component
public class ProjectDtoBuilder {

    private String name;

    public ProjectDtoBuilder() {
    }

    public ProjectDtoBuilder setName(final String name) {
        this.name = name;
        return this;
    }

    public ProjectDto build() {
        ProjectDto dto = new ProjectDto();
        dto.setName(name);

        return dto;
    }
}
