/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.rest.mappers;

import com.mycompany.entapp.snowman.domain.model.Client;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.ClientResource;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientResourceMapperUTest {

    @Test
    public void mapToClient() throws Exception {
        int clientId = 1;
        String clientName = "Client";

        ClientResource clientResource = new ClientResource();
        clientResource.setClientId(clientId);
        clientResource.setClientName(clientName);

        Client client = ClientResourceMapper.mapToClient(clientResource);

        assertEquals(clientId, client.getId());
        assertEquals(clientName, client.getClientName());
        assertEquals(null, client.getProject());
    }

    @Test
    public void mapToClientResource() throws Exception {
        fail("To be implemented");
    }

}
