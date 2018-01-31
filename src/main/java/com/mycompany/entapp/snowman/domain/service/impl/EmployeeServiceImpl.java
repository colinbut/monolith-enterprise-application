/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.domain.service.impl;

import com.mycompany.entapp.snowman.domain.model.Employee;
import com.mycompany.entapp.snowman.domain.repository.EmployeeRepository;
import com.mycompany.entapp.snowman.domain.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployee(int employeeId) {
        return employeeRepository.findEmployee(employeeId);
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.saveEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        Employee existingEmployee = getEmployee(employee.getId());

        if (existingEmployee != null) {
            employeeRepository.saveEmployee(employee);
        } else {
            throw new RuntimeException("There is no existing employee with id: " + employee.getId());
        }
    }

    @Override
    public void deleteEmployee(int employeeId) {
        Employee existingEmployee = getEmployee(employeeId);

        if (existingEmployee != null) {
            employeeRepository.removeEmployee(employeeId);
        } else {
            throw new RuntimeException("There is no existing employee with id: " + employeeId);
        }
    }
}
