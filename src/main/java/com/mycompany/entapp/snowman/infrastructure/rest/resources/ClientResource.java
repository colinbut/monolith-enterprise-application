/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.rest.resources;

import java.util.List;

public class ClientResource {

    private int clientId;
    private String clientName;
    private List<ProjectResource> projects;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List<ProjectResource> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectResource> projects) {
        this.projects = projects;
    }
}
