package com.example.empservice.entity;

import java.time.LocalDateTime;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMPLOYEE_ID")
	private Integer employeeId;
	@Column(name = "EMPLOYEE_NAME")
	private String employeeName;
	@Column(name = "EMPLOYEE_DESIGNATION")
	private String employeeDesignation;
	@Column(name = "EMPLOYEE_EMAIL")
	private String employeeEmail;
	@Column(name = "EMPLOYEE_PHONE")
	private String employeePhone;
	@Column(name = "EMPLOYEE_SALARY")
	private Integer employeeSalary;
	@Column(name = "EMPLOYEE_CITY")
	private String employeeCity;
	@Column(name = "CREATE_TIMESTAMP")
	@CreatedDate
	private LocalDateTime createTimeStamp;
	@Column(name = "UPDATE_TIMESTAMP")
	@UpdateTimestamp
	private LocalDateTime updateTimeStamp;

}
