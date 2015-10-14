package com.withblacks.api.facade.project.dto;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ProjectDtoTest {

    private ProjectDto dto;

    @Before
    public void setUp() {
        dto = new ProjectDtoBuilder().setName("Iron").build();
    }

    @Test
    public void testSetName() throws Exception {
        dto.setName("Iron");
        assertThat(dto.getName(), is("Iron"));
    }
}