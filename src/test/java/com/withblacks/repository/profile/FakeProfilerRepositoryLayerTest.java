package com.withblacks.repository.profile;

import com.withblacks.business.builder.ProfilerBuilderTest;
import com.withblacks.business.entity.Profiler;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FakeProfilerRepositoryLayerTest {

    FakeProfilerRepositoryLayer repositoryLayer;

    @Before
    public void setUp() throws Exception {
        repositoryLayer = new FakeProfilerRepositoryLayer();
    }

    @Test
    public void testFind() throws Exception {
        assertNotNull(repositoryLayer.find(1L));
    }

    @Test
    public void testFindAll() throws Exception {
        assertThat(repositoryLayer.findAll().size(), is(1));
    }

    @Test
    public void testFind1() throws Exception {
        assertNotNull(repositoryLayer.find("FirstName"));
    }

    @Test
    public void testSave() throws Exception {

    }

    @Test
    public void testModify() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }
}