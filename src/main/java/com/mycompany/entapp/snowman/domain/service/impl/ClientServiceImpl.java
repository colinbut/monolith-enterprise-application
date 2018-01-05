/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.domain.service.impl;

import com.mycompany.entapp.snowman.domain.model.Client;
import com.mycompany.entapp.snowman.domain.service.ClientService;
import com.mycompany.entapp.snowman.infrastructure.db.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    @Override
    public Client getClient(int clientId) {
        return clientDao.getClient(clientId);
    }

    @Override
    public void createClient(Client client) {

        if (getClient(client.getId()) != null) {
            throw new RuntimeException("Client already exists");
        }

        clientDao.saveClient(client);
    }

    @Override
    public void updateClient(Client client) {

        if (getClient(client.getId()) == null) {
            throw new RuntimeException("Client doesn't exists");
        }

        clientDao.saveClient(client);
    }

    @Override
    public void deleteClient(int clientId) {
        clientDao.removeClient(clientId);
    }
}
