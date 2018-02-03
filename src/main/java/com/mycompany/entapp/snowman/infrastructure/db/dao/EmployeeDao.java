/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.db.dao;

import com.mycompany.entapp.snowman.domain.model.Employee;

public interface EmployeeDao {
    Employee retrieveEmployee(int employeeId);
    void saveEmployee(Employee employee);
    void deleteEmployee(int employeeId);
}
