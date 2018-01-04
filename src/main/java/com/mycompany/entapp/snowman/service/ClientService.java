/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.service;

import com.mycompany.entapp.snowman.model.Client;

public interface ClientService {

    Client getClient(int clientId);

    void createClient(Client client);

    void updateClient(Client client);

    void deleteClient(Client client);

}
