package com.withblacks.business.entity;

public class ProfileResource {
    private String name;
    private String language;
    private String description;

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
}
