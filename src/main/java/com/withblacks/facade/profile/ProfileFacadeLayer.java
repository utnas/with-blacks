package com.withblacks.facade.profile;

import com.withblacks.business.layers.ProfileLayerImpl;
import com.withblacks.rest.profile.dto.mapper.ProfileResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileFacadeLayer {

    private ProfileLayerImpl profileLayer;
    private ProfileMapper mapper;

    public ProfileFacadeLayer() {
    }

    @Autowired
    public ProfileFacadeLayer(final ProfileLayerImpl profileLayer, final ProfileMapper mapper) {
        this.profileLayer = profileLayer;
        this.mapper = mapper;
    }

    public Iterable<ProfileResource> getProfiles() {
        return mapper.convertTo(profileLayer.findAll());
    }
}
