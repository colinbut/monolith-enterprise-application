/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.messaging.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Set;

public class ClientDTO implements Serializable {
    private int clientId;
    private String clientName;
    private Set<ProjectDTO> projectDTOS;

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

    public Set<ProjectDTO> getProjectDTOS() {
        return projectDTOS;
    }

    public void setProjectDTOS(Set<ProjectDTO> projectDTOS) {
        this.projectDTOS = projectDTOS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ClientDTO clientDTO = (ClientDTO) o;

        return new EqualsBuilder()
            .append(clientId, clientDTO.clientId)
            .append(clientName, clientDTO.clientName)
            .append(projectDTOS, clientDTO.projectDTOS)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(clientId)
            .append(clientName)
            .append(projectDTOS)
            .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("clientId", clientId)
            .append("clientName", clientName)
            .append("projectDTOS", projectDTOS)
            .toString();
    }
}
