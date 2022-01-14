package com.example.assigment.repository;

import com.example.assigment.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findByName(String name);
}
