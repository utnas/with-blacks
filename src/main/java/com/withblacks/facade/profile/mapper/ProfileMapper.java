package com.withblacks.facade.profile.mapper;

import com.withblacks.business.entity.Profiler;
import com.withblacks.rest.profile.dto.mapper.ProfileResource;
import org.springframework.stereotype.Component;

import static java.util.Collections.EMPTY_LIST;

@Component
public class ProfileMapper {

    public ProfileMapper(){
    }

    public Iterable<ProfileResource> convertTo(Iterable<Profiler> profilers) {
        return EMPTY_LIST;
    }
}
