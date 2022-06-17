package com.example.employeeapp.Services;

import com.example.employeeapp.Exception.ResourcesNotfoundException;
import com.example.employeeapp.Models.Employee;
import com.example.employeeapp.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeServiceInterface {


    private EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> findAllEmployees() {
        return repository.findAll();

    }
    @Override
    public Employee addEmployee(Employee employee) {

        return repository.save(employee);
    }

    @Override
    public Employee findEmployeeById(String id) {
        return repository.findById(id).orElseThrow(()-> new ResourcesNotfoundException("Employee doesn't exist with id:"+ id));

    }

    @Override
    public Employee updateEmployee(String id, Employee employeeDetails) {
        Employee employee=findEmployeeById(id);
        employee.setName(employeeDetails.getName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setJobTitle(employeeDetails.getJobTitle());
        employee.setSalary(employeeDetails.getSalary());

        return  repository.save(employee);

    }

    @Override
    public Map<String, Boolean> deleteEmployee(String id) {
        Employee employee=findEmployeeById(id);
        repository.delete(employee);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }


}
