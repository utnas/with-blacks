package com.withblacks.business.entity;

public class Profiler {

    private final String name;
    private final String language;
    private final String description;

    public Profiler(final String name, final String language, final String description) {
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