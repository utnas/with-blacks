package com.withblacks.repository.profile;

import com.google.common.collect.Lists;
import com.withblacks.business.entity.Profiler;

import java.util.Collection;

import static com.withblacks.business.builder.ProfilerBuilder.build;

public class ProfilesGenerator {

    public ProfilesGenerator() {
    }

    public Iterable<Profiler> generateProfiles(final int limit) {
        final Collection<Profiler> profiles = Lists.newArrayList();
        int counter = 0;
        for (int i = 0; i < limit; i++) {
            profiles.add(build("Name" + counter, "Fr", "Content of description"));
        }
        return profiles;
    }
}
