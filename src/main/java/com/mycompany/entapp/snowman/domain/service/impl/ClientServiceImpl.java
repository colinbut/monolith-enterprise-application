/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.domain.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.entapp.snowman.domain.exception.SnowmanException;
import com.mycompany.entapp.snowman.domain.model.Client;
import com.mycompany.entapp.snowman.domain.model.Project;
import com.mycompany.entapp.snowman.domain.repository.ClientRepository;
import com.mycompany.entapp.snowman.domain.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService {

    private static final Logger LOG = LoggerFactory.getLogger(ClientServiceImpl.class);

    private static final int MAX_RETRIES = 3;
    private static final String URI = "http://localhost:8080/client-system/client/{clientId}/projects";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client getClient(int clientId) {
        Client client = clientRepository.getClient(clientId);

        LOG.info("Retrieved client: {}", client);

        if (client.getProjects().isEmpty()) {
            // call Client System REST endpoint to get its project data.

            ResponseEntity<String> response = makeRequest();

            // retry
            int retryCount = 0;
            while(response.getStatusCode() != HttpStatus.OK) {
                if (retryCount > MAX_RETRIES) {
                    break;
                }

                response = makeRequest();
                retryCount++;
            }

            processResponse(response.getBody(), client);
        }

        return client;
    }

    private void processResponse(String body, Client client) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode root = objectMapper.readTree(body);
            JsonNode project = root.path("project");
            Set<Project> projects = new HashSet<>();
            projects.add(new Project());
        } catch (IOException e) {
           LOG.error("{}", e);
        }
    }

    private ResponseEntity<String> makeRequest() {
        return restTemplate.getForEntity(URI, String.class);
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
    public void deleteClient(int clientId) throws SnowmanException {

        LOG.info("Deleting client with id {}", clientId);

        if (getClient(clientId) == null) {
            LOG.error("Trying to delete a client with id {} that doesn't exist", clientId);
            throw new SnowmanException("Client doesn't exists");
        }

        clientRepository.deleteClient(clientId);
    }
}
