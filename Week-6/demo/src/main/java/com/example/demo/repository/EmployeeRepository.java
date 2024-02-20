package com.example.demo.repository;

import com.example.demo.common.EmployeeD;
import com.example.demo.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findById(int id);
    List<Employee> findAll();
    List<Employee> findByDepartmentId(int departmentId);

    Page<Employee> findAll(Pageable pageable);
    void save(EmployeeD employee);

    public List<Employee> findByNameIsContainingIgnoreCase( String query );
}
