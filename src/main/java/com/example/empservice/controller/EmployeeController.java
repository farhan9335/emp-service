package com.example.empservice.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@PostMapping(path = "/employee")
	public ResponseEntity<Employee> save( @RequestBody @Valid EmployeeDTO employeeDTO) {
		Employee employee = this.employeeService.save(employeeDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
	}
	
	
}
