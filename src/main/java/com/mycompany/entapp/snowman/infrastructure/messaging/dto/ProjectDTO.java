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
import java.util.Date;

public class ProjectDTO implements Serializable {

    private int projectId;
    private String projectTitle;
    private Date dateStarted;
    private Date dateEnded;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public Date getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(Date dateStarted) {
        this.dateStarted = dateStarted;
    }

    public Date getDateEnded() {
        return dateEnded;
    }

    public void setDateEnded(Date dateEnded) {
        this.dateEnded = dateEnded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProjectDTO that = (ProjectDTO) o;

        return new EqualsBuilder()
            .append(projectId, that.projectId)
            .append(projectTitle, that.projectTitle)
            .append(dateStarted, that.dateStarted)
            .append(dateEnded, that.dateEnded)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(projectId)
            .append(projectTitle)
            .append(dateStarted)
            .append(dateEnded)
            .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("projectId", projectId)
            .append("projectTitle", projectTitle)
            .append("dateStarted", dateStarted)
            .append("dateEnded", dateEnded)
            .toString();
    }
}
