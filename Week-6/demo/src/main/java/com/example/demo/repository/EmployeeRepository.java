package com.example.demo.repository;

import com.example.demo.entities.Employee;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findById(int id);

    List<Employee> findAll();
}
