package com.withblacks.rest.profile.dto.mapper;

public class ProfileResourceBuilder {

    public static ProfileResource build(final String name, final String language, final String description) {
        return new ProfileResource(name, language, description);
    }
}
