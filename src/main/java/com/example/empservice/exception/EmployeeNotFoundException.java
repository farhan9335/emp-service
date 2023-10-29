package com.example.empservice.exception;

public class EmployeeNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6379614151681339194L;

	public EmployeeNotFoundException(String message) {
		super(message);
	}

	
}
