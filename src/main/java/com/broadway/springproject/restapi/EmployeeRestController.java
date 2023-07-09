package com.broadway.springproject.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.broadway.springproject.model.Employee;
import com.broadway.springproject.service.EmployeeService;

@RestController
public class EmployeeRestController {
	@Autowired
	private EmployeeService es;
	@GetMapping("/emp/api/list")
	public List<Employee> getAll() {
		 return es.getAllEmps();
		
	}
	@PostMapping("/emp/api/add")
	public String add(@RequestBody Employee emp) {
		es.addEmp(emp);
		return "success";
	}
	@PutMapping("/emp/api/update")
	public String update(@RequestBody Employee emp) {
		es.updateEmp(emp);
		return "success";
	}
	@DeleteMapping("/emp/api/delete/{id}")
	public String delete(@PathVariable Long id) {
		es.deleteEmp(id);
		
		return "Deleted";
	}
	
	@GetMapping("/emp/api/j2o")
	public String jsonToObjectMapping() {

		RestTemplate temp = new RestTemplate();
		Employee emp = temp.getForObject("http://localhost/emp/api/3", Employee.class);

		return "Firstname = " + emp.getFname();
	}

	@GetMapping("/emp/api/jarray")
	public String jsonArrayToObjectArray() {

		RestTemplate temp = new RestTemplate();
		Employee[] emps = temp.getForObject("http://localhost/emp/api/list", Employee[].class);

		return "First name = "+emps[0].getFname();
	}

}
