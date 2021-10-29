package com.gpotdev.employeemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gpotdev.employeemanager.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
