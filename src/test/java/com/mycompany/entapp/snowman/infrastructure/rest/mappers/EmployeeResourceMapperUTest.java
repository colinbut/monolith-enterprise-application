/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.rest.mappers;

import com.mycompany.entapp.snowman.domain.EmployeeTestHelper;
import com.mycompany.entapp.snowman.domain.model.Employee;
import com.mycompany.entapp.snowman.domain.model.EmployeeRole;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.EmployeeResource;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeResourceMapperUTest {

    @Test
    public void givenEmployee_whenMapEmployeeToEmployeeResource_thenReturnEmployeeResource() {
        Employee employee = EmployeeTestHelper.getEmployee();

        EmployeeResource actualEmployeeResource = EmployeeResourceMapper.mapEmployeeToEmployeeResource(employee);

        assertEquals(1, actualEmployeeResource.getEmployeeId());
        assertEquals("firstName", actualEmployeeResource.getFirstName());
        assertEquals("surName", actualEmployeeResource.getSecondName());
        assertEquals("role", actualEmployeeResource.getRole());
    }

    @Test
    public void givenEmployeeResource_whenMapEmployeeResourceToEmployee_thenReturnEmployee() {

        EmployeeRole employeeRole = new EmployeeRole();
        employeeRole.setRole("Role");

        EmployeeResource employeeResource = new EmployeeResource();
        employeeResource.setEmployeeId(1);
        employeeResource.setFirstName("firstName");
        employeeResource.setSecondName("surname");
        employeeResource.setRole("Role");

        Employee actualEmployee = EmployeeResourceMapper.mapEmployeeResourceToEmployee(employeeResource);

        assertEquals(1, actualEmployee.getId());
        assertEquals("firstName", actualEmployee.getFirstname());
        assertEquals("surname", actualEmployee.getSurname());
        assertEquals(employeeRole, actualEmployee.getRole());
        assertEquals(null, actualEmployee.getProjects());
    }

}
