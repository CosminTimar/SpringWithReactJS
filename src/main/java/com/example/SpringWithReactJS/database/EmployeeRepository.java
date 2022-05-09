package com.example.SpringWithReactJS.database;

import com.example.SpringWithReactJS.dao.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Optional<Employee> findEmployeeById(Integer id);
    void deleteEmployeeById(Integer id);
}
