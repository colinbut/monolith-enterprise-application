/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.infrastructure.db.dao.impl;

import com.mycompany.entapp.snowman.domain.model.Employee;
import com.mycompany.entapp.snowman.infrastructure.db.dao.AbstractHibernateDao;
import com.mycompany.entapp.snowman.infrastructure.db.dao.EmployeeDao;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl extends AbstractHibernateDao implements EmployeeDao {
    @Override
    public Employee retrieveEmployee(int employeeId) {
        return null;
    }

    @Override
    public void saveEmployee(Employee employee) {
        getCurrentSession().save(employee);
    }

    @Override
    public void deleteEmployee(int employeeId) {
        getCurrentSession().delete(employeeId);
    }
}
