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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeRestEndpoint {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
    public ResponseEntity<EmployeeResource> getEmployee(@PathVariable Integer employeeId) {
        Employee employee = employeeService.getEmployee(employeeId);
        EmployeeResource employeeResource = EmployeeResourceMapper.mapEmployeeToEmployeeResource(employee);
        return ResponseEntity.ok(employeeResource);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity createEmployee(@Valid EmployeeResource employeeResource) {
        Employee employee = EmployeeResourceMapper.mapEmployeeResourceToEmployee(employeeResource);
        employeeService.createEmployee(employee);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity updateExistingEmployee(@Valid EmployeeResource employeeResource){
        Employee employee = EmployeeResourceMapper.mapEmployeeResourceToEmployee(employeeResource);
        employeeService.updateEmployee(employee);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "{employeeId}/delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteExistingEmployee(@PathVariable Integer employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok().build();
    }
}
