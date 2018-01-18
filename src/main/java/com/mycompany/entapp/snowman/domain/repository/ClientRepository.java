/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.domain.repository;

import com.mycompany.entapp.snowman.domain.model.Client;

public interface ClientRepository {

    Client getClient(int clientId);

    void createClient(Client client);

    void updateClient(Client client);

    void deleteClient(int clientId);
}
