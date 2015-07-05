package com.withblacks.rest.profile.dto.mapper;

import com.withblacks.business.entity.ProfileResource;

public class ProfileResourceBuilder {

    public static ProfileResource build(final String name, final String language, final String description) {
        return new ProfileResource(name, language, description);
    }
}
