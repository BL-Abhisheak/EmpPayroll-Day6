package com.day6.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day6.dto.EmployeeDTO;
import com.day6.entity.Employee;
import com.day6.repository.EmployeeRepo;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    // public Employee addEmployee(Employee employee) {
    //     return employeeRepo.save(employee);
    // }



     // create new employee
    public EmployeeDTO addEmployee(EmployeeDTO dto) {
        Employee emp = new Employee();
        emp.setName(dto.getName());
        emp.setSalary(dto.getSalary());

        Employee saved = employeeRepo.save(emp);

        return new EmployeeDTO(saved.getName(), saved.getSalary());
    }

    // public Optional<Employee> findyById(int id){
    //     return employeeRepo.findById(id);
    // }

    // find an employee by id
    public EmployeeDTO findById(int id) {
        Employee emp = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        return new EmployeeDTO(emp.getName(), emp.getSalary());
    }
    

    // public List<Employee> viewAllEmp(){
    //     return employeeRepo.findAll();
    // }


     // find all employees
    public List<EmployeeDTO> viewAllEmp() {
        return employeeRepo.findAll()
                .stream()
                .map(emp -> new EmployeeDTO(emp.getName(), emp.getSalary()))
                .collect(Collectors.toList());
    }

//     public Employee updateEmp(int id, Employee emp) {
//     return employeeRepo.findById(id)
//             .map(existingEmp -> {
//                 existingEmp.setName(emp.getName());
//                 existingEmp.setSalary(emp.getSalary());
//                 return employeeRepo.save(existingEmp);
//             })
//             .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
// }


// update an employee
    public EmployeeDTO updateEmp(int id, EmployeeDTO dto) {
        Employee emp = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        emp.setName(dto.getName());
        emp.setSalary(dto.getSalary());

        Employee updated = employeeRepo.save(emp);

        return new EmployeeDTO(updated.getName(), updated.getSalary());
    }


    //   public String deleteEmp(int id){
    //       employeeRepo.deleteById(id);
    //       return "Employee details with id : " + id + " is deleted";
    //    } 


    // delete an employee
    public String deleteEmp(int id) {
        employeeRepo.deleteById(id);
        return "Employee details with id : " + id + " is deleted";
    }
}
