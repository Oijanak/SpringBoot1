package com.broadway.springproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broadway.springproject.model.Department;
import com.broadway.springproject.repository.DepartmentRepository;
import com.broadway.springproject.service.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRepository dptrepo;
	@Override
	public void addDepartment(Department dpt) {
		
		dptrepo.save(dpt);
	}
	@Override
	public List<Department> getDepartment() {
		// TODO Auto-generated method stub
		return dptrepo.findAll();
	}
	@Override
	public Department getDepartmentById(int id) {
		return dptrepo.findById(id).get();
	}

}
