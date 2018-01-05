/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.domain.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 20, nullable = false)
    private String firstname;

    @Column(length = 20, nullable = false)
    private String surname;

    @OneToOne
    @JoinColumn(name = "employee_role_id", nullable = true) // should change this to false
    private EmployeeRole role;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "employee_project",
//        joinColumns = {
//            @JoinColumn(name = "employee_id", nullable = true, updatable = false)
//        },
//        inverseJoinColumns = {
//            @JoinColumn(name = "project_id", nullable = true, updatable = false)
//        }
//    )
//    private Set<Project> projects = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private Set<EmployeeProject> projects = new HashSet<>(0);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public EmployeeRole getRole() {
        return role;
    }

    public void setRole(EmployeeRole role) {
        this.role = role;
    }

//    public Set<Project> getProjects() {
//        return projects;
//    }
//
//    public void setProjects(Set<Project> projects) {
//        this.projects = projects;
//    }

    public Set<EmployeeProject> getProjects() {
        return projects;
    }

    public void setProjects(Set<EmployeeProject> projects) {
        this.projects = projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Employee employee = (Employee) o;

        return new EqualsBuilder()
            .append(id, employee.id)
            .append(firstname, employee.firstname)
            .append(surname, employee.surname)
            .append(role, employee.role)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(id)
            .append(firstname)
            .append(surname)
            .append(role)
            .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("id", id)
            .append("firstname", firstname)
            .append("surname", surname)
            .append("role", role)
            .toString();
    }
}
