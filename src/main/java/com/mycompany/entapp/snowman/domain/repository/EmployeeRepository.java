/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.domain.repository;

import com.mycompany.entapp.snowman.domain.model.Employee;

public interface EmployeeRepository {
    Employee findEmployee(int employeeId);
    void saveEmployee(Employee employee);
    void removeEmployee(int employeeId);
}
