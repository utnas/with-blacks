package com.withblacks.business.entity;

import com.withblacks.business.builder.ProfilerBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ProfilerTest {

    private Profiler profiler;

    @Before
    public void setUp() {
        profiler = ProfilerBuilder.build("user profile", "Fr", "The content of this profile is private");
    }

    @Test
    public void testGetName() throws Exception {
        assertThat(profiler.getName(), is("user profile"));
    }

    @Test
    public void testGetLanguage() throws Exception {
        assertThat(profiler.getLanguage(), is("Fr"));
    }

    @Test
    public void testGetDescription() throws Exception {
        assertThat(profiler.getDescription(), is("The content of this profile is private"));
    }
}