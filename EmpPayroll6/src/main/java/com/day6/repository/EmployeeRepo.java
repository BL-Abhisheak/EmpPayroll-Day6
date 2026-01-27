package com.day6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.day6.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
    
}

