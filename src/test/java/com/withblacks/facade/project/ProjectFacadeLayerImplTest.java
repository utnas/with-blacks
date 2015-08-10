package com.withblacks.facade.project;

import com.google.common.collect.Iterables;
import com.withblacks.business.entities.project.Project;
import com.withblacks.business.layers.project.ProjectLayer;
import com.withblacks.business.layers.project.ProjectLayerImpl;
import com.withblacks.facade.project.dto.ProjectDto;
import com.withblacks.facade.project.dto.ProjectMapper;
import org.junit.Before;
import org.junit.Test;

import static com.withblacks.business.layers.project.ProjectMockHelper.*;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ProjectFacadeLayerImplTest {

    private ProjectFacadeLayerImpl facade;
    private ProjectLayer layer;
    private Project project;
    private ProjectDto projectDto;

    @Before
    public void setUp() {
        layer = mock(ProjectLayerImpl.class);
        project = mockProject("Iron");
        projectDto = mockProjectDto("Iron");
        ProjectMapper mapper = mockProjectMapper(projectDto, project);
        facade = new ProjectFacadeLayerImpl(layer, mapper);
    }

    @Test
    public void testGetProject() throws Exception {
        doReturn(project).when(layer).find(anyLong());
        assertThat(facade.getProject(1L).getName(), is("Iron"));
    }

    @Test
    public void testGetProjectByName() throws Exception {
        doReturn(project).when(layer).find(anyString());
        assertThat(facade.getProject("Iron").getName(), is("Iron"));
    }

    @Test
    public void testGetProjects() throws Exception {
        doReturn(asList(project)).when(layer).findAll();
        assertThat(Iterables.getLast(facade.getProjects()).getName(), is("Iron"));
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