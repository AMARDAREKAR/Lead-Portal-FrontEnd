package com.yoan.serviceImpl;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.yoan.model.Employee;
import com.yoan.repository.EmployeeRepository;
import com.yoan.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public ResponseEntity<Employee> getEmployeeById(int employeeId) {
		if (employeeRepository.existsById(employeeId))
			return new ResponseEntity<Employee>(employeeRepository.findById(employeeId).get(), HttpStatus.OK);
		else
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}
	
	@Override
	public void deleteEmployeeById(int employeeId,Principal principal) {
		if (employeeRepository.existsById(employeeId))
		{
			employeeRepository.deleteById(employeeId);
		}
	}
	
	@Override
	public ResponseEntity<Employee> addEmployee(Employee employee, Principal principal) {
		if (employeeRepository.existsById(employee.getEmployeeId())) {
			return new ResponseEntity<Employee>(HttpStatus.CONFLICT);
		} else {
			employee.setPassword(new BCryptPasswordEncoder().encode(employee.getPassword()));
			if (principal == null) {
				employee.setModifiedBy(1);
				employee.setCreatedBy(1);
			} else {
				employee.setModifiedBy(Integer.parseInt(principal.getName()));
				employee.setCreatedBy(Integer.parseInt(principal.getName()));
			}
			employee.setCreatedDate(new Date());
			employee.setModifiedDate(new Date());
			return new ResponseEntity<Employee>(employeeRepository.save(employee), HttpStatus.CREATED);
		}
	}

	@Override
	public ResponseEntity<Employee> updateEmployee(Employee employee, Principal principal) {
		employee.setPassword(new BCryptPasswordEncoder().encode(employee.getPassword()));
		employee.setCreatedBy(getEmployeeById(employee.getEmployeeId()).getBody().getCreatedBy());
		employee.setCreatedDate(getEmployeeById(employee.getEmployeeId()).getBody().getCreatedDate());
		employee.setModifiedBy(Integer.parseInt(principal.getName()));
		employee.setModifiedDate(new Date());
		return new ResponseEntity<Employee>(employeeRepository.save(employee), HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<Employee> changeEmployeeStatus(Employee employee, Principal principal) {
		employee.setCreatedBy(getEmployeeById(employee.getEmployeeId()).getBody().getCreatedBy());
		employee.setCreatedDate(getEmployeeById(employee.getEmployeeId()).getBody().getCreatedDate());
		employee.setModifiedBy(Integer.parseInt(principal.getName()));
		employee.setModifiedDate(new Date());
		return new ResponseEntity<Employee>(employeeRepository.save(employee), HttpStatus.OK);
	}
}