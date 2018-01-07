/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.db.dao.impl;

import com.mycompany.entapp.snowman.infrastructure.db.dao.AbstractHibernateDao;
import com.mycompany.entapp.snowman.infrastructure.db.dao.ClientDao;
import com.mycompany.entapp.snowman.domain.model.Client;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDaoImpl extends AbstractHibernateDao implements ClientDao {

    @Override
    public Client getClient(int clientId) {
        return (Client) getCurrentSession().get(Client.class, clientId);
    }

    @Override
    public void saveClient(Client client) {
        getCurrentSession().save(client);
    }

    @Override
    public void removeClient(int clientId) {
        Client clientToDelete = getClient(clientId);
        getCurrentSession().delete(clientToDelete);
    }
}
