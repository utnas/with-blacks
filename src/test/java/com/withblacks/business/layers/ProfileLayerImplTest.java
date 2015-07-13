package com.withblacks.business.layers;

import com.withblacks.business.entity.Profiler;
import com.withblacks.repository.profile.FakeProfilerRepositoryLayer;
import org.junit.Before;
import org.junit.Test;

import static com.google.common.collect.Iterables.size;
import static com.google.common.collect.Lists.newArrayList;
import static com.withblacks.business.builder.ProfilerBuilder.build;
import static com.withblacks.business.builder.ProfilerBuilderTest.hasProperties;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ProfileLayerImplTest {

    private ProfileLayerImpl profileLayer;
    private FakeProfilerRepositoryLayer repository;

    @Before
    public void setUp() throws Exception {
        repository = mock(FakeProfilerRepositoryLayer.class);
        final Profiler profiler = build("FirstName", "FR", "Description of my content");
        doReturn(profiler).when(repository).find(anyString());
        doReturn(profiler).when(repository).find(anyLong());
        profileLayer = new ProfileLayerImpl(repository);
    }

    @Test
    public void testFindByName() throws Exception {
        assertNotNull(profileLayer.find("FistName"));
    }

    @Test
    public void testFindAll() throws Exception {
        doReturn(newArrayList(build("FirstName", "FR", "Description of my content"),
                        build("FirstName", "FR", "Description of my content"))
        ).when(repository).findAll();
        assertThat(size(profileLayer.findAll()), is(2));
    }

    @Test
    public void testFindById() throws Exception {
        assertNotNull(profileLayer.find(1L));
    }

    @Test
    public void testCreate() throws Exception {
        final Profiler build = build("FirstName", "FR", "Description of my content");
        doReturn(build).when(repository).save(any());
        assertThat(profileLayer.create(build), hasProperties("FirstName", "FR", "Description of my content"));
    }

    @Test
    public void testUpdateShouldReturnTrue() throws Exception {
        final Profiler build = build("FirstName", "FR", "Description of my content");
        doReturn(true).when(repository).modify(anyLong(), any(Profiler.class));
        assertThat(profileLayer.update(1L, build), is(true));
    }

    @Test
    public void testUpdateShouldReturnFalse() throws Exception {
        final Profiler build = build("FirstName", "FR", "Description of my content");
        doReturn(false).when(repository).modify(anyLong(), any(Profiler.class));
        assertThat(profileLayer.update(1L, build), is(false));
    }

    @Test
    public void testDeleteShouldReturnTrue() throws Exception {
        doReturn(true).when(repository).delete(anyLong());
        assertThat(profileLayer.delete(1L), is(true));
    }

    @Test
    public void testDeleteShouldReturnFalse() throws Exception {
        assertThat(profileLayer.delete(1L), is(false));
    }
}