package com.example.demo.controller;

import com.example.demo.entities.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class EmployeeController {
    @GetMapping("/")
    public String greeting(){
        return "Welcome";
    }
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("employees/{id}")
    public Employee findById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("/{id}/employees")
    public List<Employee> getAllEmployeesByDepartmentId(@PathVariable int id){
        return employeeService.getByDepartmentId(id);
    }
}
