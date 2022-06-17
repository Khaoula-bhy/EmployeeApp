package com.example.employeeapp.Services;

import com.example.employeeapp.Models.Employee;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface EmployeeServiceInterface {
    public Employee addEmployee(Employee employee);
    public List<Employee> findAllEmployees();

    public Employee updateEmployee(String id,Employee employee);

    public Employee findEmployeeById(String id);

    public Map<String, Boolean> deleteEmployee(String id);

}
