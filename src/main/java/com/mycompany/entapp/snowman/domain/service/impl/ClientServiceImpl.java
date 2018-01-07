/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.domain.service.impl;

import com.mycompany.entapp.snowman.domain.exception.SnowmanException;
import com.mycompany.entapp.snowman.domain.model.Client;
import com.mycompany.entapp.snowman.domain.service.ClientService;
import com.mycompany.entapp.snowman.infrastructure.db.dao.ClientDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private static final Logger LOG = LoggerFactory.getLogger(ClientServiceImpl.class);

    @Autowired
    private ClientDao clientDao;

    @Override
    public Client getClient(int clientId) {
        Client client = clientDao.getClient(clientId);

        LOG.info("Retrieved client: {}", client);

        return client;
    }

    @Override
    public void createClient(Client client) throws SnowmanException {

        LOG.info("Creating client {}", client);

        if (getClient(client.getId()) != null) {
            throw new SnowmanException("Client already exists");
        }

        clientDao.saveClient(client);
    }

    @Override
    public void updateClient(Client client) throws SnowmanException {

        LOG.info("Updating client {}", client);

        if (getClient(client.getId()) == null) {
            throw new SnowmanException("Client doesn't exists");
        }

        clientDao.saveClient(client);
    }

    @Override
    public void deleteClient(int clientId) {
        clientDao.removeClient(clientId);
    }
}
