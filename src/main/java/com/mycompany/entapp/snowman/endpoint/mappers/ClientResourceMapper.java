/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.endpoint.mappers;

import com.mycompany.entapp.snowman.endpoint.resources.ClientResource;
import com.mycompany.entapp.snowman.model.Client;

public final class ClientResourceMapper {

    private ClientResourceMapper() {
    }

    public static Client mapToClient(ClientResource clientResource) {
        Client client = new Client();
        client.setClientName(clientResource.getClientName());
        client.setProject(ProjectResourceMapper.mapToProjects(clientResource.getProjects()));
        return client;
    }

    public static ClientResource mapToClientResource(Client client) {
        return null;
    }
}
