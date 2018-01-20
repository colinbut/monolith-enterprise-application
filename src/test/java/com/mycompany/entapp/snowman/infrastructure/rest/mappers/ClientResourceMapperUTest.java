/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.rest.mappers;

import com.mycompany.entapp.snowman.domain.model.Client;
import com.mycompany.entapp.snowman.domain.model.Project;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.ClientResource;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.ProjectResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ProjectResourceMapper.class})
public class ClientResourceMapperUTest {

    @Test
    public void testMapToClient() throws Exception {
        int clientId = 1;
        String clientName = "Client";

        ClientResource clientResource = new ClientResource();
        clientResource.setClientId(clientId);
        clientResource.setClientName(clientName);

        Set<Project> projects = new HashSet<>();
        projects.add(new Project());

        PowerMockito.mockStatic(ProjectResourceMapper.class);

        PowerMockito.when(ProjectResourceMapper.mapToProjects(Matchers.anyListOf(ProjectResource.class)))
            .thenReturn(projects);

        Client client = ClientResourceMapper.mapToClient(clientResource);

        assertEquals(clientId, client.getId());
        assertEquals(clientName, client.getClientName());
        assertEquals(projects, client.getProjects());
    }

    @Test
    public void testMapToClientResource() throws Exception {
        int clientId = 1;
        String clientName = "Client";

        Client client = new Client();
        client.setId(clientId);
        client.setClientName(clientName);

        List<ProjectResource> projectResources = new ArrayList<>();
        ProjectResource projectResource = new ProjectResource();
        projectResource.setProjectId(1);
        projectResource.setTitle("Project");
        projectResources.add(projectResource);

        PowerMockito.mockStatic(ProjectResourceMapper.class);

        PowerMockito.when(ProjectResourceMapper.mapToProjectResources(Matchers.anySetOf(Project.class)))
            .thenReturn(projectResources);

        ClientResource clientResource = ClientResourceMapper.mapToClientResource(client);

        assertEquals(clientId, clientResource.getClientId());
        assertEquals(clientName, clientResource.getClientName());
        assertEquals(projectResources, clientResource.getProjects());
    }

}
