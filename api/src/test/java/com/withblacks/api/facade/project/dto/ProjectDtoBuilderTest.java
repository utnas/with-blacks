package com.withblacks.api.facade.project.dto;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ProjectDtoBuilderTest {

    private ProjectDtoBuilder builder;

    @Before
    public void setUp() {
        builder = new ProjectDtoBuilder();
    }

    @Test
    public void itShouldBuildAProjectDto() throws Exception {
        ProjectDto dto = builder.setName("Iron").build();
        assertThat(dto.getName(), is("Iron"));
    }
}