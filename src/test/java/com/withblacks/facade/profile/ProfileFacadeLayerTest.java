package com.withblacks.facade.profile;

import com.google.common.collect.Iterables;
import com.withblacks.business.layers.ProfileLayerImpl;
import com.withblacks.facade.profile.mapper.ProfileMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static java.util.Collections.EMPTY_LIST;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;

public class ProfileFacadeLayerTest {

    private ProfileFacadeLayer facade;
    private ProfileLayerImpl layer;
    private ProfileMapper mapper;

    @Before
    public void setUp() {
        layer = Mockito.mock(ProfileLayerImpl.class);
        mapper = Mockito.mock(ProfileMapper.class);

        facade = new ProfileFacadeLayer(layer, mapper);
    }

    @Test
    public void testGetProfilesShouldReturnEmptyList() throws Exception {
        doReturn(EMPTY_LIST).when(layer).findAll();
        doReturn(EMPTY_LIST).when(mapper).convertTo(any(EMPTY_LIST.getClass()));

        assertThat(Iterables.isEmpty(facade.getProfiles()), is(true));
    }
}