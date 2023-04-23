package com.broadway.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.broadway.springproject.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
