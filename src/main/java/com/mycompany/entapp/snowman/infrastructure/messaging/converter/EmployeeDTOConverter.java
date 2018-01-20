/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.messaging.converter;

import com.mycompany.entapp.snowman.domain.model.Employee;
import com.mycompany.entapp.snowman.domain.model.EmployeeProject;
import com.mycompany.entapp.snowman.domain.model.Project;
import com.mycompany.entapp.snowman.infrastructure.messaging.dto.EmployeeDTO;
import com.mycompany.entapp.snowman.infrastructure.messaging.dto.ProjectDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class EmployeeDTOConverter {
    private EmployeeDTOConverter() {
    }

    public static EmployeeDTO convertToEmployeeDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setFirstName(employee.getFirstname());
        employeeDTO.setSurname(employee.getSurname());
        employeeDTO.setRole(employee.getRole().getRole());

        Set<ProjectDTO> projectDTOSet = ProjectDTOConverter.convertToProjectDTOS(getProjectForEmployee(employee));
        employeeDTO.setProjectDTOList(new ArrayList<>(projectDTOSet));

        return employeeDTO;
    }

    private static Set<Project> getProjectForEmployee(Employee employee) {
        Set<Project> projects = new HashSet<>();
        Set<EmployeeProject> employeeProjects = employee.getProjects();
        for (EmployeeProject employeeProject : employeeProjects) {
            projects.add(employeeProject.getProject());
        }
        return projects;
    }
}
