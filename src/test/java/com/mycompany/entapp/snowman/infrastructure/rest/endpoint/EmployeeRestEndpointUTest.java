/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.rest.endpoint;

import com.mycompany.entapp.snowman.domain.model.Employee;
import com.mycompany.entapp.snowman.domain.service.EmployeeService;
import com.mycompany.entapp.snowman.infrastructure.rest.mappers.EmployeeResourceMapper;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.EmployeeResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(EmployeeResourceMapper.class)
public class EmployeeRestEndpointUTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeRestEndpoint systemUnderTest = new EmployeeRestEndpoint();

    @Test
    public void testGetEmployeeShouldGetEmployee() {
        Integer employeeId = 5;

        Employee employee = new Employee();
        EmployeeResource employeeResource = new EmployeeResource();

        PowerMockito.when(EmployeeResourceMapper.mapEmployeeToEmployeeResource(employee)).thenReturn(employeeResource);

        ResponseEntity<EmployeeResource> responseEntity = systemUnderTest.getEmployee(employeeId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(employeeResource, responseEntity.getBody());
    }

    @Test
    public void testCreateEmployeeShouldCreateEmployee() {
        PowerMockito.mockStatic(EmployeeResourceMapper.class);

        Employee employee = new Employee();

        EmployeeResource employeeResource = new EmployeeResource();

        PowerMockito.when(EmployeeResourceMapper.mapEmployeeResourceToEmployee(employeeResource)).thenReturn(employee);
        Mockito.doNothing().when(employeeService).createEmployee(employee);

        systemUnderTest.createEmployee(employeeResource);

        PowerMockito.verifyStatic(EmployeeResourceMapper.class);
        Mockito.verify(employeeService, Mockito.times(1)).createEmployee(employee);
    }

    @Test
    public void testUpdateExistingEmployeeShouldUpdateExistingEmployee() {
        PowerMockito.mockStatic(EmployeeResourceMapper.class);

        Employee employee = new Employee();

        EmployeeResource employeeResource = new EmployeeResource();

        PowerMockito.when(EmployeeResourceMapper.mapEmployeeResourceToEmployee(employeeResource)).thenReturn(employee);
        Mockito.doNothing().when(employeeService).updateEmployee(employee);

        systemUnderTest.updateExistingEmployee(employeeResource);

        PowerMockito.verifyStatic(EmployeeResourceMapper.class);
        Mockito.verify(employeeService, Mockito.times(1)).updateEmployee(employee);
    }

    @Test
    public void testDeleteEmployeeShouldDeleteEmployee(){
        int employeeId = 7;

        Mockito.doNothing().when(employeeService).deleteEmployee(employeeId);

        systemUnderTest.deleteExistingEmployee(employeeId);

        Mockito.verify(employeeService, Mockito.times(1)).deleteEmployee(employeeId);
    }

}
