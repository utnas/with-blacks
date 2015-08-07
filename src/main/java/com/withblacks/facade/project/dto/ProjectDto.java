package com.withblacks.facade.project.dto;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Component;

@Component
public class ProjectDto extends ResourceSupport {

    private long id;
    private String name;

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
