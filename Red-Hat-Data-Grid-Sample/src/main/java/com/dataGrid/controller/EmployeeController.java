package com.dataGrid.controller;

import com.dataGrid.manager.DataGridManager;
import com.dataGrid.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;
import java.util.UUID;

/*
 * @project Red-Hat-Data-Grid-Sample
 * @author Digvijay Singh
 */

@RestController
@RequestMapping("/")
public class EmployeeController {
    @Autowired
    DataGridManager dataGridManager;


    @GetMapping("/employeeIds")
    public Set<String> getAllEmployeesId() {
        Set<String> uuids = dataGridManager.getEmployeeCache().keySet();
        return uuids;
    }
    @GetMapping("/employees")
    public Map<String, Employee> getAllEmployees() {
        Map<String, Employee> employeeMap = dataGridManager.getEmployeeCache().getAll(dataGridManager.getEmployeeCache().keySet());
        return employeeMap;
    }
}
