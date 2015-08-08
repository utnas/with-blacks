package com.withblacks.rest.project;

import com.withblacks.facade.project.ProjectFacadeLayer;
import com.withblacks.facade.project.ProjectFacadeLayerImpl;
import com.withblacks.facade.project.dto.ProjectDto;
import org.junit.Before;
import org.junit.Test;

import static com.withblacks.business.layers.project.ProjectMockHelper.mockProjectDto;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.springframework.http.HttpStatus.OK;

public class ProjectRestTest {

    private ProjectRest restAPI;
    private ProjectFacadeLayer facade;
    private ProjectDto projectDto;

    @Before
    public void setUp() {
        facade = mock(ProjectFacadeLayerImpl.class);

        projectDto = mockProjectDto("Iron");
        restAPI = new ProjectRest(facade);
    }

    @Test
    public void testFindAll() throws Exception {
        doReturn(singletonList(projectDto)).when(facade).getProjects();
        assertThat(restAPI.findAll().getStatusCode(), is(OK));
    }

    @Test
    public void testFindById() throws Exception {
        doReturn(projectDto).when(facade).getProject(anyLong());
        assertThat(restAPI.findById(1L).getStatusCode(), is(OK));
    }

    @Test
    public void testCreate() throws Exception {
        doReturn(projectDto).when(facade).create(projectDto);
        assertThat(restAPI.create(projectDto).getStatusCode(), is(OK));
    }

    @Test
    public void testUpdate() throws Exception {
        doReturn(projectDto).when(facade).update(anyLong(), any(ProjectDto.class));
        assertThat(restAPI.update(1L, projectDto).getStatusCode(), is(OK));
    }
}