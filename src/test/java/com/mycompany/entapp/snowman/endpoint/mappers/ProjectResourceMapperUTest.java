/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.endpoint.mappers;

import com.mycompany.entapp.snowman.endpoint.resources.ProjectResource;
import com.mycompany.entapp.snowman.model.Project;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Date;

public class ProjectResourceMapperUTest extends TestCase {

    @Test
    public void testMapToProject() throws Exception {

        ProjectResource projectResource = new ProjectResource();

        Project mappedProject = ProjectResourceMapper.mapToProject(projectResource);

        assertEquals(1, mappedProject.getId());
        assertEquals("Project Title", mappedProject.getProjectTitle());
        assertEquals(new Date(), mappedProject.getDateStarted());
        assertEquals(new Date(), mappedProject.getDateEnded());
    }

    @Test
    public void testMapToProjectResource() throws Exception {
    }

    @Test
    public void testMapToProjects() throws Exception {
    }

}
