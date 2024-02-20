package com.example.demo.controller;

import com.example.demo.common.EmployeeD;
import com.example.demo.entities.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/pemployees")
    public Page<Employee> getAllEmployeesPageable(Pageable pageable){
        return employeeService.getAllEmployeesPageable(pageable);
    }

    @PostMapping("/")
    public void createEmployee(@RequestBody EmployeeD employee){
        employeeService.createEmployee(employee);
    }

    @GetMapping("employee/search")
    public List<Employee> findByNameIsContainingIgnoreCase(String query){
        return employeeService.findByNameIsContainingIgnoreCase(query);
    }
}
