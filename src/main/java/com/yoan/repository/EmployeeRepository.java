package com.yoan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yoan.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
