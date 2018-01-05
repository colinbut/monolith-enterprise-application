/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.rest.endpoint;

import com.mycompany.entapp.snowman.infrastructure.rest.mappers.ClientResourceMapper;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.ClientResource;
import com.mycompany.entapp.snowman.domain.model.Client;
import com.mycompany.entapp.snowman.domain.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientRestEndpoint {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/{clientId}", method = RequestMethod.GET)
    public void getClientInfo(@PathVariable("clientId") Integer clientId) {
        clientService.getClient(clientId);
    }

    @RequestMapping(value = "/{clientId}", method = RequestMethod.POST)
    public void createClientInfo(@RequestBody ClientResource clientResource) {
        Client client = ClientResourceMapper.mapToClient(clientResource);
        clientService.createClient(client);
    }
}
