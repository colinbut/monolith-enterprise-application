/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.domain.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "employee_project")
public class EmployeeProjectV2 implements Serializable {

    @EmbeddedId
    private EmployeeProjectId primaryKey = new EmployeeProjectId();

    @Temporal(TemporalType.DATE)
    @Column(name = "date_started")
    private Date dateStarted;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_ended")
    private Date dateEnded;

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

    public EmployeeProjectId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(EmployeeProjectId primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Transient
    public Employee getEmployee() {
        return primaryKey.getEmployee();
    }

    public void setEmployee(Employee employee) {
        primaryKey.setEmployee(employee);
    }

    public Project getProject() {
        return primaryKey.getProject();
    }

    public void setProject(Project project) {
        primaryKey.setProject(project);
    }


}
