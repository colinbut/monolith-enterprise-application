/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.dao;

import com.mycompany.entapp.snowman.model.Client;

public interface ClientDao {

    Client getClient(int clientId);

    void saveClient(Client client);

    void removeClient(int clientId);

}
