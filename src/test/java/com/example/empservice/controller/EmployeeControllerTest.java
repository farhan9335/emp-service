package com.example.empservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.example.empservice.dto.EmployeeDTO;
import com.example.empservice.entity.Employee;
import com.example.empservice.repo.EmployeeRepository;
import com.example.empservice.service.EmployeeService;

@SpringBootTest
public class EmployeeControllerTest {

	private EmployeeService employeeService;

	@MockBean
	private EmployeeRepository employeeRepository;

	@BeforeEach
	public void setup() {
		employeeService = new EmployeeService(employeeRepository);
	}

	@Test
	public void getAllEmployeeTest() {

		List<Employee> employees = Stream.of(
				Employee.build(456, "Farhan", "Manager", "khan.farhan1985@gmail.com", "7827113422", 12000, "Lakhimpur",
						LocalDateTime.now(), LocalDateTime.now()),
				Employee.build(456, "Amit", "Sr Manager", "amit@gmail.com", "9891234576", 16000, "Kanpur",
						LocalDateTime.now(), LocalDateTime.now()))
				.collect(Collectors.toList());
		Mockito.when(employeeRepository.findAll()).thenReturn(employees);
		List<Employee> allEmployeesByService = employeeService.getAllEmployees();
		assertEquals(employees.size(), allEmployeesByService.size());

	}
	
	@Test
	public void getEmployeeByIdTest() {
		Optional<Employee> employee = Optional.of(Employee.build(456, "Farhan", "Manager", "khan.farhan1985@gmail.com", "7827113422", 12000, "Lakhimpur",
				LocalDateTime.now(), LocalDateTime.now()));
		Mockito.when(employeeRepository.findById(employee.get().getEmployeeId())).thenReturn(employee);
		assertEquals(employee.get().getEmployeeId(), employeeService.getEmployeeById(employee.get().getEmployeeId()).getEmployeeId());
	}
	
	@Test
	public void deleteEmployeeTest() {
		Optional<Employee> employee = Optional.of(Employee.build(456, "Farhan", "Manager", "khan.farhan1985@gmail.com", "7827113422", 12000, "Lakhimpur",
				LocalDateTime.now(), LocalDateTime.now()));		
		Mockito.when(employeeRepository.findById(employee.get().getEmployeeId())).thenReturn(employee);
		Employee employeeByService = employeeService.getEmployeeById(employee.get().getEmployeeId());
		assertEquals(employee.get().getEmployeeId(), employeeByService.getEmployeeId());
		when(employeeRepository.save(employee.get())).thenReturn(employee.get());
		employeeRepository.deleteById(employee.get().getEmployeeId());
		verify(employeeRepository,times(1)).deleteById(employee.get().getEmployeeId());
		
	}
	
	@Test
	public void updateEmployeeTest() {
		EmployeeDTO employeeDTO = EmployeeDTO.build(456, "Amit", "Manager", "khan.farhan1985@gmail.com", "7827113422", 12000, "Lakhimpur");
		Optional<Employee> employee = Optional.of(Employee.build(456, "Farhan", "Manager", "khan.farhan1985@gmail.com", "7827113422", 12000, "Lakhimpur",
				LocalDateTime.now(), LocalDateTime.now()));
		Optional<Employee> updatedEmployee = Optional.of(Employee.build(456, "Amit", "Manager", "khan.farhan1985@gmail.com", "7827113422", 12000, "Lakhimpur",
				LocalDateTime.now(), LocalDateTime.now()));
		when(employeeRepository.findById(employeeDTO.getEmployeeId())).thenReturn(employee);
		assertEquals(employee.get().getEmployeeId(), employee.get().getEmployeeId());
		Mockito.when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(updatedEmployee.get());
		assertEquals(updatedEmployee.get().getEmployeeName(), employeeService.save(employeeDTO).getEmployeeName());
		
	}

	@Test
	public void saveTest() {
		EmployeeDTO employeeDTO = EmployeeDTO.build(456, "Amit", "Manager", "khan.farhan1985@gmail.com", "7827113422", 12000, "Lakhimpur");
		Optional<Employee> employee = Optional.of(Employee.build(456, "Amit", "Manager", "khan.farhan1985@gmail.com", "7827113422", 12000, "Lakhimpur",
				LocalDateTime.now(), LocalDateTime.now()));
		Mockito.when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(employee.get());
		assertEquals(employee.get().getEmployeeId(), employeeService.save(employeeDTO).getEmployeeId());
	}
}
