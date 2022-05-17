package com.example.SpringWithReactJS.controller;


import com.example.SpringWithReactJS.dao.Employee;
import com.example.SpringWithReactJS.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController{

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployeeList(){
        List<Employee> employeeList = employeeService.getEmployeeList();
        return new ResponseEntity<>(employeeList,HttpStatus.OK);
    }

    @GetMapping(path="/get-by-id/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id){
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee,HttpStatus.FOUND);
    }

    @PutMapping(path = "update-employee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee employee1 = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(employee1,HttpStatus.OK);

    }

    @PostMapping(path = "/add-employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee employee1 = employeeService.addEmployee(employee);
        return new ResponseEntity<>(employee1,HttpStatus.CREATED);
    }

    @PutMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
