/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.domain.service.impl;

import com.mycompany.entapp.snowman.domain.EmployeeTestHelper;
import com.mycompany.entapp.snowman.domain.model.Employee;
import com.mycompany.entapp.snowman.domain.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplUTest {

    private static final int EMPLOYEE_ID = 3;

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl classUnderTest = new EmployeeServiceImpl();

    @Test
    public void testGetEmployee(){
        Employee employee = EmployeeTestHelper.getEmployee();

        Mockito.when(employeeRepository.findEmployee(EMPLOYEE_ID)).thenReturn(employee);

        Employee actualEmployee = classUnderTest.getEmployee(EMPLOYEE_ID);

        assertEquals(employee, actualEmployee);
        Mockito.verify(employeeRepository, Mockito.times(1)).findEmployee(EMPLOYEE_ID);
    }

    @Test
    public void testCreateEmployee() {
        Employee employee = EmployeeTestHelper.getEmployee();

        Mockito.doNothing().when(employeeRepository).saveEmployee(employee);

        classUnderTest.createEmployee(employee);

        Mockito.verify(employeeRepository, Mockito.times(1)).saveEmployee(employee);
    }

    @Test
    public void testUpdateEmployeeShouldUpdateEmployee() {
        Employee employee = EmployeeTestHelper.getEmployee();

        Mockito.when(employeeRepository.findEmployee(EMPLOYEE_ID)).thenReturn(employee);
        Mockito.doNothing().when(employeeRepository).saveEmployee(employee);

        classUnderTest.updateEmployee(employee);

        Mockito.verify(employeeRepository, Mockito.times(1)).findEmployee(EMPLOYEE_ID);
        Mockito.verify(employeeRepository, Mockito.times(1)).saveEmployee(employee);

    }

    @Test(expected = RuntimeException.class)
    public void testUpdateEmployeeShouldThrowExceptionWhenNoExistingEmployeeFound() {
        Mockito.when(employeeRepository.findEmployee(EMPLOYEE_ID)).thenReturn(null);
        classUnderTest.updateEmployee(new Employee());
    }

    @Test
    public void testDeleteEmployeeShouldDeleteEmployee() {
        Employee employee = EmployeeTestHelper.getEmployee();

        Mockito.when(employeeRepository.findEmployee(EMPLOYEE_ID)).thenReturn(employee);
        Mockito.doNothing().when(employeeRepository).removeEmployee(EMPLOYEE_ID);

        classUnderTest.deleteEmployee(EMPLOYEE_ID);

        Mockito.verify(employeeRepository, Mockito.times(1)).findEmployee(EMPLOYEE_ID);
        Mockito.verify(employeeRepository, Mockito.times(1)).removeEmployee(EMPLOYEE_ID);
    }

    @Test
    public void testDeleteEmployeeShouldThrowExceptionWhenNoExistingEmployeeFound() {
        Mockito.when(employeeRepository.findEmployee(EMPLOYEE_ID)).thenReturn(null);
        classUnderTest.deleteEmployee(EMPLOYEE_ID);
    }

}
