package com.example.SpringWithReactJS.database;


import com.example.SpringWithReactJS.dao.Department;
import com.example.SpringWithReactJS.dao.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class InMemoryDataBase {
    private static final List<Employee> EMPLOYEE_LIST = new ArrayList<>();
    @Bean
    CommandLineRunner commandLineRunner(
            EmployeeRepository employeeRepository
    ){
        return args ->{
            EMPLOYEE_LIST.add(new Employee("Mircea",
                    "Imparate",
                    "chiarel@siiarel.com",
                    "ceaMaiParola",
                    Department.IT));

            EMPLOYEE_LIST.add(new Employee("Ana",
                    "Mirek",
                    "nuchiarel@ecelalalt.com",
                    "cancerDeParola",
                    Department.HR));

            employeeRepository.saveAll(EMPLOYEE_LIST);
        };
    }
}
