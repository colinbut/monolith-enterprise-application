/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.domain.repository.impl;

import com.mycompany.entapp.snowman.domain.ProjectTestHelper;
import com.mycompany.entapp.snowman.domain.model.Project;
import com.mycompany.entapp.snowman.infrastructure.db.dao.ProjectDao;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ProjectRepositoryImplUTest {

    private static final int PROJECT_ID = 1;

    @Mock
    private ProjectDao projectDao;

    @InjectMocks
    private ProjectRepositoryImpl classUnderTest = new ProjectRepositoryImpl();

    @Test
    public void giveProjectId_whenFindProject_thenReturnProjectWithThatProjectId() {


        Project project = ProjectTestHelper.getProject();

        Mockito.when(projectDao.retrieveProject(PROJECT_ID)).thenReturn(project);

        Project actualProject = classUnderTest.findProject(PROJECT_ID);

        Mockito.verify(projectDao, Mockito.times(1)).retrieveProject(PROJECT_ID);

        assertEquals(project, actualProject);
    }

    @Test
    public void givenProject_whenSaveProject_thenPersistProject() {
        Project project = ProjectTestHelper.getProject();

        Mockito.doNothing().when(projectDao).saveProject(project);

        classUnderTest.saveProject(project);

        Mockito.verify(projectDao, Mockito.times(1)).saveProject(project);
    }

    @Test
    public void givenProjectId_whenRemoveProject_thenDeleteProject() {
        Mockito.doNothing().when(projectDao).removeProject(PROJECT_ID);

        classUnderTest.removeProject(PROJECT_ID);

        Mockito.verify(projectDao, Mockito.times(1)).removeProject(PROJECT_ID);
    }



}
