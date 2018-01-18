/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.domain.service.impl;

import com.mycompany.entapp.snowman.domain.exception.SnowmanException;
import com.mycompany.entapp.snowman.domain.model.Client;
import com.mycompany.entapp.snowman.domain.repository.ClientRepository;
import com.mycompany.entapp.snowman.domain.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private static final Logger LOG = LoggerFactory.getLogger(ClientServiceImpl.class);

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client getClient(int clientId) {
        Client client = clientRepository.getClient(clientId);

        LOG.info("Retrieved client: {}", client);

        return client;
    }

    @Override
    public void createClient(Client client) throws SnowmanException {

        LOG.info("Creating client {}", client);

        if (getClient(client.getId()) != null) {
            throw new SnowmanException("Client already exists");
        }

        clientRepository.createClient(client);
    }

    @Override
    public void updateClient(Client client) throws SnowmanException {

        LOG.info("Updating client {}", client);

        if (getClient(client.getId()) == null) {
            throw new SnowmanException("Client doesn't exists");
        }

        clientRepository.updateClient(client);
    }

    @Override
    public void deleteClient(int clientId) {
        clientRepository.deleteClient(clientId);
    }
}
