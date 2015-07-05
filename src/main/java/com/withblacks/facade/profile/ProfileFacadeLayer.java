package com.withblacks.facade.profile;

import com.withblacks.business.entity.ProfileResource;
import org.springframework.stereotype.Component;

import static java.util.Collections.EMPTY_LIST;

@Component
public class ProfileFacadeLayer {

    public ProfileFacadeLayer() {
    }


    public Iterable<ProfileResource> getProfiles() {
        return EMPTY_LIST;
    }
}
