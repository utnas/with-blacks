package com.withblacks.api.facade.project;

import com.google.common.collect.Iterables;
import com.withblacks.api.business.layers.project.ProjectMockHelper;
import com.withblacks.api.business.entities.project.Project;
import com.withblacks.api.business.layers.project.ProjectLayerImpl;
import com.withblacks.api.facade.project.dto.ProjectDto;
import org.junit.Before;
import org.junit.Test;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ProjectFacadeImplTest {

    private ProjectFacadeImpl facade;
    private ProjectLayerImpl layer;
    private Project project;
    private ProjectDto projectDto;

    @Before
    public void setUp() {
        layer = mock(ProjectLayerImpl.class);
        project = ProjectMockHelper.mockProject("Iron", emptyList());
        projectDto = ProjectMockHelper.mockProjectDto("Iron");
        facade = new ProjectFacadeImpl(layer, ProjectMockHelper.mockProjectMapper(projectDto, project));
    }

    @Test
    public void testGetProject() throws Exception {
        doReturn(project).when(layer).find(1L);
        assertThat(facade.getOne(1L).getName(), is("Iron"));
    }

    @Test
    public void testGetProjectByName() throws Exception {
        doReturn(project).when(layer).find(anyString());
        assertThat(facade.getOne("Iron").getName(), is("Iron"));
    }

    @Test
    public void testGetProjects() throws Exception {
        doReturn(singletonList(project)).when(layer).findAll();
        assertThat(Iterables.getLast(facade.getAll()).getName(), is("Iron"));
    }

    @Test
    public void testCreate() throws Exception {
        doReturn(project).when(layer).create(any(Project.class));
        assertThat(facade.create(projectDto).getName(), is("Iron"));
    }

    @Test
    public void testUpdate() throws Exception {
        doReturn(project).when(layer).update(anyLong(), any(Project.class));
        assertThat(facade.update(1L, projectDto).getName(), is("Iron"));
    }

    @Test
    public void testRemove() throws Exception {

    }
}