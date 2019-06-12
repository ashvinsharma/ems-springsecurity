package com.ems.springsecurity.service;

import com.ems.springsecurity.model.Employee;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(Employee employee);

    List<Employee> findAllEmployees();

    void deleteEmployee(int id);

    Employee findEmployee(String email);

    void updateEmployee(Employee employee);
}
