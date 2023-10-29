package com.example.empservice.service;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.empservice.dto.EmployeeDTO;
import com.example.empservice.entity.Employee;
import com.example.empservice.repo.EmployeeRepository;

@Service
public class EmployeeService {
	
	Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee save(EmployeeDTO employeeDTO) {
		Employee employee = Employee.build(0, employeeDTO.getEmployeeName(), employeeDTO.getEmployeeDesignation(),
				employeeDTO.getEmployeeEmail(), employeeDTO.getEmployeePhone(), employeeDTO.getEmployeeSalary(),
				employeeDTO.getEmployeeCity(), LocalDateTime.now(), LocalDateTime.now());
		return this.employeeRepository.save(employee);
	}
}
