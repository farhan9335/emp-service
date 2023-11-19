package com.example.empservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.empservice.dto.EmployeeDTO;
import com.example.empservice.entity.Employee;
import com.example.empservice.service.EmployeeService;
import jakarta.validation.Valid;

@RestController
public class EmployeeController {

	Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(path = "/testEmployee")
	public String testEmployee() {
		return "Welcome, emp-service is up and working properly";
	}

	@PostMapping(path = "/employee")
	public ResponseEntity<Employee> save(@RequestBody @Valid EmployeeDTO employeeDTO) {
		Employee employee = this.employeeService.save(employeeDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
	}

	@GetMapping(path = "/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
		Employee employee = this.employeeService.getEmployeeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}

	@GetMapping(path = "/employee")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.status(HttpStatus.OK).body(this.employeeService.getAllEmployees());
	}

	@DeleteMapping(path = "/employee/{id}")
	public ResponseEntity<Employee> deleteEmployeeById(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.employeeService.deleteEmployee(id));
	}

	@PutMapping(path = "/employee")
	public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
		return ResponseEntity.status(HttpStatus.OK).body(this.employeeService.updateEmployee(employeeDTO));
	}
}
