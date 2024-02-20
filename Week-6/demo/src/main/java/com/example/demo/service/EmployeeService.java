package com.example.demo.service;

import com.example.demo.common.EmployeeD;
import com.example.demo.entities.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    public Employee getEmployeeById(int id){
        return employeeRepository.findById(id);
    }
    public List<Employee> getByDepartmentId(int departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }
    public Page<Employee> getAllEmployeesPageable(Pageable page){
        return employeeRepository.findAll(page);
    }

    public void createEmployee(EmployeeD employee){
        employeeRepository.save(employee);
    }

    public List<Employee> findByNameIsContainingIgnoreCase(String query){
       return employeeRepository.findByNameIsContainingIgnoreCase(query);
    }
}
