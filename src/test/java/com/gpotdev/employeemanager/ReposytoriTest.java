package com.gpotdev.employeemanager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.gpotdev.employeemanager.model.Employee;
import com.gpotdev.employeemanager.repository.EmployeeRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ReposytoriTest {

	@Autowired
	private EmployeeRepo repository;

	@Test
	void contextLoads() {
		
		System.out.println(repository.save(geraEmployeer()));
	}
	
	public Employee geraEmployeer() {
		return new Employee(null, 
				"teste", 
				"teste", 
				"teste", 
				"teste", 
				"teste", 
				"teste");
		
	}
	
}
