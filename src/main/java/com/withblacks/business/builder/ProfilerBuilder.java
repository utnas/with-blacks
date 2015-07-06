package com.withblacks.business.builder;

import com.withblacks.business.entity.Profiler;

public class ProfilerBuilder {

    public static Profiler build(final String name, final String language, final String description) {
        return new Profiler(name, language, description);
    }
}
