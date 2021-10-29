package com.gpotdev.employeemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gpotdev.employeemanager.model.Employee;
import com.gpotdev.employeemanager.services.EmployeeServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/employee")
@Api(value = "APi REST employee")
public class EmployeerController {
    
	@Autowired
	private EmployeeServices service;

	@GetMapping("/all")
	@ApiOperation(value = "Lista todos os Brokerages do banco")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = service.findAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);

	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployeesById(@PathVariable("id") Long id) {
		Employee employee = service.findById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);

	}

	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployees(@RequestBody Employee employee) {
		Employee newEmployee = service.addEmployee(employee);
		return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);

	}

	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployees(@RequestBody Employee employee) {
		Employee newEmployee = service.updateEmployee(employee);
		return new ResponseEntity<>(newEmployee, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployees(@PathVariable("id") Long id) {
		String employee = service.deleteEmployees(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);

	}
}
