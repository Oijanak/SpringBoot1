package com.broadway.springproject.service;

import java.util.List;

import com.broadway.springproject.model.Department;

public interface DepartmentService {
	void addDepartment(Department dpt);

	List<Department> getDepartment();

	Department getDepartmentById(int id);
	

}
