package com.example.employeeapp.Controllers;


import com.example.employeeapp.Models.Employee;
import com.example.employeeapp.Services.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    public EmployeeServiceInterface employeeService;

    @Autowired

    public EmployeeController(EmployeeServiceInterface employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees= employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id){
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);

    }
    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee employeeModel= employeeService.addEmployee(employee);
        return new ResponseEntity<>(employeeModel,HttpStatus.OK);
    }
    @PutMapping("/employee/{id}")

    public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee employeeDetails){
        Employee C1= employeeService.updateEmployee(id,employeeDetails);
        return   new ResponseEntity<>(C1,HttpStatus.OK);
    }
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable String id){
        Map<String,Boolean> response= employeeService.deleteEmployee(id);
        return  ResponseEntity.ok(response);
    }
}
