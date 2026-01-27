package com.day6.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.day6.entity.Employee;
import com.day6.service.EmployeeService;



@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }


    @GetMapping("/emp/{id}")
    public Optional<Employee> viewById(@PathVariable int id, Employee employee){
        return employeeService.findyById(id);
    }

    @GetMapping("/emp/all")
    public List<Employee> viewAll(Employee emp){
        return employeeService.viewAllEmp();
    }

    @PutMapping("/emp/{id}")
    public Employee updateEmp(@PathVariable int id,@RequestBody Employee empl){
        return employeeService.updateEmp(id, empl);
    }


    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable int id){
        return employeeService.deleteEmp(id);
    }
}
