package com.day6.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day6.entity.Employee;
import com.day6.repository.EmployeeRepo;



@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Optional<Employee> findyById(int id){
        return employeeRepo.findById(id);
    }
    

    public List<Employee> viewAllEmp(){
        return employeeRepo.findAll();
    }

    public Employee updateEmp(int id, Employee emp) {
    return employeeRepo.findById(id)
            .map(existingEmp -> {
                existingEmp.setName(emp.getName());
                existingEmp.setSalary(emp.getSalary());
                return employeeRepo.save(existingEmp);
            })
            .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
}


      public String deleteEmp(int id){
          employeeRepo.deleteById(id);
          return "Employee details with id : " + id + " is deleted";
       } 

}

