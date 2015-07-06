package com.withblacks.facade.profile;

import com.withblacks.business.entity.Profiler;
import com.withblacks.rest.profile.dto.mapper.ProfileResource;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Collections.EMPTY_LIST;

@Component
public class ProfileMapper {

    public ProfileMapper(){
    }

    public Iterable<ProfileResource> convertTo(List<Profiler> profilers) {
        return EMPTY_LIST;
    }
}
