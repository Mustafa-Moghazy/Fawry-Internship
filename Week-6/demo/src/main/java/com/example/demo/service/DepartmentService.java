package com.example.demo.service;

import com.example.demo.entities.Department;
import com.example.demo.entities.Employee;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    public List<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }
}
