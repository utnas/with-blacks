package com.withblacks.api.rest.project;

import com.withblacks.api.business.layers.project.ProjectMockHelper;
import com.withblacks.api.facade.project.ProjectFacadeImpl;
import com.withblacks.api.rest.ProjectRest;
import com.withblacks.api.facade.project.dto.ProjectDto;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import static com.withblacks.api.rest.utils.ActionResponseUtil.mockActionResponse;
import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.OK;

public class ProjectRestTest {

    private ProjectRest restAPI;
    private ProjectFacadeImpl facade;
    private ProjectDto projectDto;

    @Before
    public void setUp() {
        facade = mock(ProjectFacadeImpl.class);
        projectDto = ProjectMockHelper.mockProjectDto("Iron");
        restAPI = new ProjectRest(facade, mockActionResponse(new ResponseEntity<>(OK)));
    }

    @Test
    public void testFindAll() throws Exception {
        doReturn(singletonList(projectDto)).when(facade).getAll();
        assertThat(restAPI.findAll().getStatusCode(), is(OK));
    }

    @Test
    public void testFindById() throws Exception {
        doReturn(projectDto).when(facade).getOne(anyLong());
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

    @Test
    public void testDelete() throws Exception {
        doNothing().when(facade).remove(1L);
        MatcherAssert.assertThat(restAPI.delete(1L).getStatusCode(), is(OK));
    }
}