package com.example.empservice.dto;
import com.example.empservice.utility.ContactNumberConstraint;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Getter
@Setter
public class EmployeeDTO {

	private Integer employeeId;
	@NotBlank(message = "Employee Name should not be blank or empty")
	private String employeeName;
	@NotBlank(message = "Employee Designation should not be blank or empty")
	private String employeeDesignation;
	@NotBlank(message = "Employee Email should not be blank or empty")
	@Email(message = "Email should be proper format")
	private String employeeEmail;
	@NotBlank(message = "Employee Phone should not be blank or empty")
	@ContactNumberConstraint
	private String employeePhone;
	@NotNull(message = "Employee Salary should not be blank or empty")
	private Integer employeeSalary;
	@NotBlank(message = "Employee City should not be blank or empty")
	private String employeeCity;
}
