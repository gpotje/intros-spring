package com.gpotdev.employeemanager.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpotdev.employeemanager.exception.TabuleiroBadRequest;
import com.gpotdev.employeemanager.model.Employee;
import com.gpotdev.employeemanager.repository.EmployeeRepo;

@Service
public class EmployeeServices {

	@Autowired
	private EmployeeRepo repository;

	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return repository.save(employee);
	}

	public Employee updateEmployee(Employee employee) {
		return repository.save(employee);
	}

	public List<Employee> findAllEmployees() {
		return repository.findAll();
	}

	public Employee findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new TabuleiroBadRequest("não foi encontrado dados com esse id"));
	}

	public String deleteEmployees(Long id) {
		Employee emp = findById(id);
		if (emp != null) {
			repository.deleteById(id);
			return "deletado com sucesso";
		}
		return "Não foi encontrado dados referente ao id informado";

	}

}
