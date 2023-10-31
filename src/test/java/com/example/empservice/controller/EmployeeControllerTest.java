package com.example.empservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.empservice.dto.EmployeeDTO;
import com.example.empservice.entity.Employee;
import com.example.empservice.repo.EmployeeRepository;
import com.example.empservice.service.EmployeeService;

@SpringBootTest
public class EmployeeControllerTest {

	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeRepository employeeRepository;

	

	@Test
	public void getAllEmployeesTest() {
		when(employeeRepository.findAll()).thenReturn(Stream.of(
				Employee.build(456, "Farhan", "Manager", "khan.farhan1985@gmail.com", "7827113422", 12000, "Lakhimpur",
						LocalDateTime.now(), LocalDateTime.now()),
				Employee.build(456, "Farhan", "Manager", "khan.farhan1985@gmail.com", "7827113422", 12000, "Lakhimpur",
						LocalDateTime.now(), LocalDateTime.now()))
				.collect(Collectors.toList()));
		assertEquals(2, employeeService.getAllEmployees().size());
	}

	@Test
	public void getEmployeeByIdTest() {
		Integer employeeId = 1;
		Optional<Employee> employee = Optional.of(Employee.build(456, "Farhan", "Manager", "khan.farhan1985@gmail.com",
				"7827113422", 12000, "Lakhimpur", LocalDateTime.now(), LocalDateTime.now()));
		when(employeeRepository.findById(employeeId)).thenReturn(employee);
		assertEquals(employee.get(), employeeService.getEmployeeById(employeeId));
	}
	
	@Test
	public void saveTest() {
		Employee employee = Employee.build(456, "Farhan", "Manager", "khan.farhan1985@gmail.com",
				"7827113422", 12000, "Lakhimpur", LocalDateTime.now(), LocalDateTime.now());
		EmployeeDTO employeedto = EmployeeDTO.build(456, "Farhan", "Manager", "khan.farhan1985@gmail.com",
				"7827113422", 12000, "Lakhimpur");
		when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(employee);
		assertEquals(employee, employeeService.save(employeedto));
	}
	
	@Test
	public void deleteEmployeeTest() {
		int employeeId = 456;
		Optional<Employee> employee = Optional.of(Employee.build(456, "Farhan", "Manager", "khan.farhan1985@gmail.com",
				"7827113422", 12000, "Lakhimpur", LocalDateTime.now(), LocalDateTime.now()));
		when(employeeRepository.findById(employee.get().getEmployeeId())).thenReturn(employee);
		assertEquals(employee.get(), employeeService.getEmployeeById(employeeId));
		
		
	}
	
	
	@Test
	public void updateEmployeeTest() {
		Employee employee = Employee.build(456, "Farhan", "Manager", "khan.farhan1985@gmail.com",
				"7827113422", 12000, "Lakhimpur", LocalDateTime.now(), LocalDateTime.now());
		EmployeeDTO employeedto = EmployeeDTO.build(456, "Farhan", "Sr Manager", "khan.farhan1985@gmail.com",
				"7827113422", 12000, "Lakhimpur");
		when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(employee);
		assertEquals(employee, employeeService.save(employeedto));
	}
}
