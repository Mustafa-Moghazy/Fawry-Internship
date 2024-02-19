package com.example.demo.controller;

import com.example.demo.entities.Department;
import com.example.demo.entities.Employee;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartment();
    }
    @GetMapping("/{id}/employees")
    public List<Employee> getAllEmployeesByDepartmentId(@PathVariable int id){
        return departmentService.getEmployeesByDepartmentId(id);
    }
}
