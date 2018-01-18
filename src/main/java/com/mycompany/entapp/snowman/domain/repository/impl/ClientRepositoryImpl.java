/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.domain.repository.impl;

import com.mycompany.entapp.snowman.domain.model.Client;
import com.mycompany.entapp.snowman.domain.repository.ClientRepository;
import com.mycompany.entapp.snowman.infrastructure.db.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class ClientRepositoryImpl implements ClientRepository {

    @Autowired
    private ClientDao clientDao;

    @Cacheable(value = "clientFindCache", key = "#clientId")
    @Override
    public Client getClient(int clientId){
        return clientDao.getClient(clientId);
    }

    @Override
    public void createClient(Client client){
        clientDao.saveClient(client);
    }

    @CachePut(value = "clientFindCache", key = "#client.clientId")
    @Override
    public void updateClient(Client client){
        clientDao.saveClient(client);
    }

    @CacheEvict(value = "clientFindCache", key = "#clientId")
    @Override
    public void deleteClient(int clientId){
        clientDao.removeClient(clientId);
    }
}
