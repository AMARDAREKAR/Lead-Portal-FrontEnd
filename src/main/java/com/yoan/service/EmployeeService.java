package com.yoan.service;

import java.security.Principal;

import org.springframework.http.ResponseEntity;

import com.yoan.model.Employee;

public interface EmployeeService {
	
	Iterable<Employee> getAllEmployee();
	ResponseEntity<Employee> addEmployee(Employee employee,Principal principal);
	ResponseEntity<Employee> getEmployeeById(int employeeId);
	ResponseEntity<Employee> updateEmployee(Employee employee,Principal principal);
	ResponseEntity<Employee> changeEmployeeStatus(Employee employee,Principal principal);
	void deleteEmployeeById(int employeeId, Principal principal);
}
