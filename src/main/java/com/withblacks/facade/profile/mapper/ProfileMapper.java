package com.withblacks.facade.profile.mapper;

import com.withblacks.business.entity.Profiler;
import com.withblacks.rest.profile.dto.mapper.ProfileResource;
import com.withblacks.rest.profile.dto.mapper.ProfileResourceBuilder;
import org.springframework.stereotype.Component;

import java.util.Collection;

import static com.google.common.collect.Lists.newArrayList;

@Component
public class ProfileMapper {

    public ProfileMapper(){
    }

    public Iterable<ProfileResource> convertTo(Iterable<Profiler> profilers) {
        final Collection<ProfileResource> result = newArrayList();
        for (final Profiler profiler : profilers) {
            result.add(ProfileResourceBuilder.build(profiler.getName(), profiler.getLanguage(), profiler.getDescription()));
        }
        return result;
    }
}
