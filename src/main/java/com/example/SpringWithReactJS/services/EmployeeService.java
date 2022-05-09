package com.example.SpringWithReactJS.services;


import com.example.SpringWithReactJS.Exception.EmployeeNotFoundException;
import com.example.SpringWithReactJS.dao.Employee;
import com.example.SpringWithReactJS.database.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getEmployeeList() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findEmployeeById(id).orElseThrow(() -> new EmployeeNotFoundException(""));
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    public void deleteEmployee(int id) {
        employeeRepository.deleteEmployeeById(id);
    }
}
