/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.endpoint.mappers;

import com.mycompany.entapp.snowman.endpoint.resources.ProjectResource;
import com.mycompany.entapp.snowman.model.Project;
import junit.framework.TestCase;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.Date;

public class ProjectResourceMapperUTest extends TestCase {

    @Test
    public void testMapToProject() throws Exception {
        Date dateStarted = new DateTime(2018,1,1,0,0,0).toDate();
        Date dateEnded = new DateTime(2018,5,1,0,0,0).toDate();

        ProjectResource projectResource = new ProjectResource();
        projectResource.setProjectId(1);
        projectResource.setTitle("Project Title");
        projectResource.setDateStarted(dateStarted);
        projectResource.setDateEnded(dateEnded);

        Project mappedProject = ProjectResourceMapper.mapToProject(projectResource);

        assertEquals(1, mappedProject.getId());
        assertEquals("Project Title", mappedProject.getProjectTitle());
        assertEquals(dateStarted, mappedProject.getDateStarted());
        assertEquals(dateEnded, mappedProject.getDateEnded());
    }

    @Test
    public void testMapToProjectResource() throws Exception {
        int projectId = 1;
        String projectTitle = "Project Title";
        Date dateStarted = new DateTime(2018,1,1,0,0,0).toDate();
        Date dateEnded = new DateTime(2018,5,1,0,0,0).toDate();

        Project project = new Project();
        project.setId(projectId);
        project.setProjectTitle(projectTitle);
        project.setDateStarted(dateStarted);
        project.setDateEnded(dateEnded);

        ProjectResource projectResource = ProjectResourceMapper.mapToProjectResource(project);

        assertEquals(projectId, projectResource.getProjectId());
        assertEquals(projectTitle, projectResource.getTitle());
        assertEquals(dateStarted, projectResource.getDateStarted());
        assertEquals(dateEnded, projectResource.getDateEnded());
    }

    @Test
    public void testMapToProjects() throws Exception {
        fail("To be Implemented");
    }

}
