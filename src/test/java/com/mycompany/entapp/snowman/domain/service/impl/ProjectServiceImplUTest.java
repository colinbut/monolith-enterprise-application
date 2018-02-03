/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.domain.service.impl;

import com.mycompany.entapp.snowman.domain.ProjectTestHelper;
import com.mycompany.entapp.snowman.domain.model.Project;
import com.mycompany.entapp.snowman.domain.repository.ProjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ProjectServiceImplUTest {

    private static final int PROJECT_ID = 1;

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectServiceImpl classUnderTest = new ProjectServiceImpl();

    @Test
    public void testCreateProjectShouldCreateProject(){
        Project project = ProjectTestHelper.getProject();

        Mockito.doNothing().when(projectRepository).saveProject(project);

        classUnderTest.createProject(project);

        Mockito.verify(projectRepository, Mockito.times(1)).saveProject(project);
    }

    @Test
    public void testGetProjetcWithProjectIdShouldReturnProjectWithThatProjectId() {
        Project project = ProjectTestHelper.getProject();

        Mockito.when(projectRepository.findProject(PROJECT_ID)).thenReturn(project);

        Project actualProject = classUnderTest.getProject(PROJECT_ID);

        Mockito.verify(projectRepository, Mockito.times(1)).findProject(PROJECT_ID);
        assertEquals(project, actualProject);
    }

    @Test
    public void testUpdateProjectThatExistShouldUpdateProject() {
        Project existingProject = ProjectTestHelper.getProject();

        Mockito.when(projectRepository.findProject(existingProject.getId())).thenReturn(existingProject);
        Mockito.doNothing().when(projectRepository).saveProject(existingProject);

        classUnderTest.updateProject(existingProject);

        Mockito.verify(projectRepository, Mockito.times(1)).findProject(existingProject.getId());
        Mockito.verify(projectRepository, Mockito.times(1)).saveProject(existingProject);
    }

    @Test
    public void testUpdateProjectThatDoesNotExistShouldThrowException() {
        Project existingProject = ProjectTestHelper.getProject();
        try {
            Mockito.when(projectRepository.findProject(existingProject.getId())).thenReturn(null);

            classUnderTest.updateProject(existingProject);

            fail("Should not get here");
        } catch (RuntimeException ex) {
            Mockito.verify(projectRepository, Mockito.never()).saveProject(existingProject);
            assertEquals("Can't update an unknown project " + existingProject, ex.getLocalizedMessage());
        }
    }

    @Test
    public void testDeleteExistingProjectShouldDeleteExistingProject() {
        Project existingProject = ProjectTestHelper.getProject();

        Mockito.when(projectRepository.findProject(PROJECT_ID)).thenReturn(existingProject);
        Mockito.doNothing().when(projectRepository).removeProject(PROJECT_ID);

        classUnderTest.deleteProject(PROJECT_ID);

        Mockito.verify(projectRepository, Mockito.times(1)).removeProject(PROJECT_ID);
    }

    @Test(expected = RuntimeException.class)
    public void testDeleteExistingProjectThatDoesNotExistShouldThrowException() {

        Mockito.when(projectRepository.findProject(PROJECT_ID)).thenReturn(null);

        classUnderTest.deleteProject(PROJECT_ID);
    }

}
