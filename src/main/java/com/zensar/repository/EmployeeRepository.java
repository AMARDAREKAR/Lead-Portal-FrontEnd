package com.zensar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
