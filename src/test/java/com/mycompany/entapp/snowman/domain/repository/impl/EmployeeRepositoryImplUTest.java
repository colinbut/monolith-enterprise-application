/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.domain.repository.impl;

import com.mycompany.entapp.snowman.domain.EmployeeTestHelper;
import com.mycompany.entapp.snowman.domain.model.Employee;
import com.mycompany.entapp.snowman.infrastructure.db.dao.EmployeeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeRepositoryImplUTest {
    private static final int EMPLOYEE_ID = 1;

    @Mock
    private EmployeeDao employeeDao;

    @InjectMocks
    private EmployeeRepositoryImpl sut = new EmployeeRepositoryImpl();

    @Test
    public void testFindEmployee(){
        Employee employee = EmployeeTestHelper.getEmployee();

        Mockito.when(employeeDao.retrieveEmployee(EMPLOYEE_ID)).thenReturn(employee);

        Employee actualEmployee = sut.findEmployee(EMPLOYEE_ID);

        assertEquals(employee, actualEmployee);
    }

    @Test
    public void testSaveEmployee() {
        Employee employee = EmployeeTestHelper.getEmployee();

        Mockito.doNothing().when(employeeDao).saveEmployee(employee);

        sut.saveEmployee(employee);

        Mockito.verify(employeeDao, Mockito.times(1)).saveEmployee(employee);
    }

    @Test
    public void testRemoveEmployee() {
        Mockito.doNothing().when(employeeDao).deleteEmployee(EMPLOYEE_ID);

        sut.removeEmployee(EMPLOYEE_ID);

        Mockito.verify(employeeDao, Mockito.times(1)).deleteEmployee(EMPLOYEE_ID);
    }
}
