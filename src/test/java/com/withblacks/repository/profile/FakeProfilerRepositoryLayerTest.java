package com.withblacks.repository.profile;

import com.withblacks.business.entity.Profiler;
import org.junit.Before;
import org.junit.Test;

import static com.google.common.collect.Iterables.size;
import static com.google.common.collect.Lists.newArrayList;
import static com.withblacks.business.builder.ProfilerBuilder.build;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class FakeProfilerRepositoryLayerTest {

    private FakeProfilerRepositoryLayer repositoryLayer;
    private ProfilesGenerator profilesGenerator;

    @Before
    public void setUp() throws Exception {
        profilesGenerator = mock(ProfilesGenerator.class);
        doReturn(newArrayList(build("Name", "Fr", "Content of description"))).when(profilesGenerator).generateProfiles(anyInt());
        repositoryLayer = new FakeProfilerRepositoryLayer(profilesGenerator);
    }

    @Test
    public void testFind() throws Exception {
        doReturn(newArrayList(build("Name", "Fr", "Content of description"))).when(profilesGenerator).generateProfiles(anyInt());
        assertNotNull(repositoryLayer.find(1L));
    }

    @Test
    public void testFindAll() throws Exception {
        assertThat(size(repositoryLayer.findAll()), is(1));
    }

    @Test
    public void testFind1() throws Exception {
        assertNotNull(repositoryLayer.find("Name"));
    }

    @Test
    public void testSave() throws Exception {
        final Profiler mock = mock(Profiler.class);
        assertNotNull(repositoryLayer.save(mock));
    }

    @Test
    public void testModify() throws Exception {
        final Profiler mock = mock(Profiler.class);
        assertTrue(repositoryLayer.modify(1L, mock));
    }

    @Test
    public void testDelete() throws Exception {
        assertTrue(repositoryLayer.delete(1L));
    }
}