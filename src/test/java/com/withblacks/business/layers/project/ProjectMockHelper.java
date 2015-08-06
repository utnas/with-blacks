package com.withblacks.business.layers.project;

import com.withblacks.business.entities.Project;
import org.mockito.Mockito;

import static org.mockito.Mockito.doReturn;

public class ProjectMockHelper {

    public static Project mockProject(final String name) {
        final Project project = Mockito.mock(Project.class);
        doReturn(name).when(project).getName();

        return project;
    }
}
