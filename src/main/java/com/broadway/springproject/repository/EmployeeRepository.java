package com.broadway.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.broadway.springproject.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
}