package com.withblacks.api.business.layers.project;

import com.withblacks.api.business.entities.project.Project;
import com.withblacks.api.repository.ProjectRepository;
import org.junit.Before;
import org.junit.Test;

import static com.google.common.collect.Iterables.getLast;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ProjectLayerImplTest {

    private ProjectLayerImpl layer;
    private ProjectRepository repository;
    private Project project;

    @Before
    public void setUp() {
        repository = mock(ProjectRepository.class);
        project = ProjectMockHelper.mockProject("Iron", emptyList());
        layer = new ProjectLayerImpl(repository);
    }

    @Test
    public void testFind() throws Exception {
        doReturn(project).when(repository).findOne(anyLong());

        assertThat(layer.find(1L).getName(), is("Iron"));
    }

    @Test
    public void testFindAll() throws Exception {
        doReturn(singletonList(project)).when(repository).findAll();

        assertThat(getLast(layer.findAll()).getName(), is("Iron"));
    }

    @Test
    public void testFindByName() throws Exception {
        doReturn(project).when(repository).findByName(anyString());

        assertThat(layer.find("Iron").getName(), is("Iron"));
    }

    @Test
    public void testCreate() throws Exception {
        doReturn(project).when(repository).save(any(Project.class));

        assertThat(layer.create(project).getName(), is("Iron"));
    }

    @Test
    public void testUpdate() throws Exception {
        doReturn(project).when(repository).save(any(Project.class));

        assertThat(layer.update(1L, project).getName(), is("Iron"));
    }
}