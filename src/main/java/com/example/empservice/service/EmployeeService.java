package com.example.empservice.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.empservice.dto.EmployeeDTO;
import com.example.empservice.entity.Employee;
import com.example.empservice.exception.EmployeeNotFoundException;
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

	public Employee getEmployeeById(int id) {
		Optional<Employee> employee = this.employeeRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new EmployeeNotFoundException("Employee not found with id " + id);
		}
	}

	public List<Employee> getAllEmployees() {
		List<Employee> employees = this.employeeRepository.findAll();
		if (employees.size() > 0) {
			return employees;
		} else {
			throw new EmployeeNotFoundException("Employees not available, please contact to Administrator");
		}
	}

	public Employee deleteEmployee(int id) {
		Employee employee = getEmployeeById(id);
		this.employeeRepository.deleteById(id);
		return employee;
	}

	public Employee updateEmployee(EmployeeDTO employeeDTO) {
		Optional<Employee> employee = this.employeeRepository.findById(employeeDTO.getEmployeeId());
		if (employee.isPresent()) {
			Employee employee2 = employee.get();
			employee2 = Employee.build(employee2.getEmployeeId(), employeeDTO.getEmployeeName(),
					employeeDTO.getEmployeeDesignation(), employeeDTO.getEmployeeEmail(),
					employeeDTO.getEmployeePhone(), employeeDTO.getEmployeeSalary(), employeeDTO.getEmployeeCity(),
					employee2.getCreateTimeStamp(), LocalDateTime.now());
			return employeeRepository.save(employee2);
		} else {
			throw new EmployeeNotFoundException("Employee not found with id " + employeeDTO.getEmployeeId());
		}

	}

	public EmployeeService(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	

}
