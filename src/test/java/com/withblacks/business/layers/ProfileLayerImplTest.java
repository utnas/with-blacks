package com.withblacks.business.layers;

import com.withblacks.repository.profile.ProfilerRepositoryLayer;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class ProfileLayerImplTest {

    ProfileLayerImpl profileLayer;
    private ProfilerRepositoryLayer repository;

    @Before
    public void setUp() throws Exception {
        repository = mock(ProfilerRepositoryLayer.class);
        profileLayer = new ProfileLayerImpl(repository);
    }

    @Test
    public void testFind() throws Exception {

    }

    @Test
    public void testFindAll() throws Exception {

    }

    @Test
    public void testFind1() throws Exception {

    }

    @Test
    public void testCreate() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }
}