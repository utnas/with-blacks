package com.withblacks.rest.profile.dto.mapper;

import org.springframework.hateoas.ResourceSupport;

public class ProfileResource extends ResourceSupport {
    private String name;
    private String language;
    private String description;
    private Long ids;

    public ProfileResource(final String name, final String language, final String description) {
        this.name = name;
        this.language = language;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public String getDescription() {
        return description;
    }

    public Long getIds() {
        return 1L;
    }
}
