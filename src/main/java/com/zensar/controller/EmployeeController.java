package com.zensar.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.model.Employee;
import com.zensar.service.EmployeeService;

@RestController
@CrossOrigin()
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	// Get all employees
	@GetMapping(value="employees")
	public Iterable<Employee> getAllEmployee()
	{
		return employeeService.getAllEmployee();
	}	
	// Get employee by employeeId
	@GetMapping(value="employee/{employeeId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeId") int employeeId)
	{
		return employeeService.getEmployeeById(employeeId);
	}
	// Post an employee
	@PostMapping(value="employee")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee,Principal principal)
	{
		return employeeService.addEmployee(employee,principal);
	}
	// Update employee details
	@PutMapping(value="employee")
	public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee,Principal principal)
	{
		return employeeService.updateEmployee(employee,principal);
	}
	// Change employee status
	@PutMapping(value="changeEmployeeStatus")
	public ResponseEntity<Employee> changeEmployeeStatus(@Valid @RequestBody Employee employee,Principal principal)
	{
		return employeeService.changeEmployeeStatus(employee,principal);
	}
	// Delete employee by passing employeeId
	@DeleteMapping("employee/{employeeId}")
	public void deleteEmployeeById(@PathVariable("employeeId") int employeeId, Principal principal)
	{
		employeeService.deleteEmployeeById(employeeId,principal);
	}
}