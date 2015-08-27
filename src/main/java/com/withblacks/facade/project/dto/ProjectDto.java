package com.withblacks.facade.project.dto;

import com.withblacks.facade.EntityDto;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.stereotype.Component;

@Component
public class ProjectDto extends ResourceSupport implements EntityDto {

    private long id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
