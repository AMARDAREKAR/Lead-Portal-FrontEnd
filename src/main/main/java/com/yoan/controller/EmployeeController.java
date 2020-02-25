package com.yoan.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yoan.model.Employee;
import com.yoan.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value="employees")
	public Iterable<Employee> getAllEmployee()
	{
		return employeeService.getAllEmployee();
	}
	
	@GetMapping(value="employee/{employeeId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeId") int employeeId)
	{
		return employeeService.getEmployeeById(employeeId);
	}
	
	@PostMapping(value="employee")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee,Principal principal)
	{
		return employeeService.addEmployee(employee,principal);
	}
	
	@PutMapping(value="employee")
	public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee,Principal principal)
	{
		return employeeService.updateEmployee(employee,principal);
	}
}