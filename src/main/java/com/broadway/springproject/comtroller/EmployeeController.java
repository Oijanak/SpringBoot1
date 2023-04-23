package com.broadway.springproject.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.broadway.springproject.model.Employee;
import com.broadway.springproject.service.DepartmentService;
import com.broadway.springproject.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private DepartmentService ds;
	@Autowired
	private EmployeeService emps;
	@GetMapping("/employee")
	public String getEmployee(Model model) {
		model.addAttribute("dplist",ds.getDepartment());
		
		return "employee";
	}
	@PostMapping("/employee")
	public String postEmployee(@ModelAttribute Employee employee) {
		emps.addEmp(employee);
		return "redirect:/employee";
	}
	@GetMapping("/employeeList")
	public String getEmployeeList(Model model) {
		model.addAttribute("elist",emps.getAllEmps());
		return "EmployeeList";
	}
	@GetMapping("/editEmp")
	public String editEmployee(@RequestParam long id,Model model) {
		model.addAttribute("dplist",ds.getDepartment());
		model.addAttribute("empModel",emps.getEmpById(id));
		return "EditEmployee";
		
	}
	@PostMapping("/updateEmp")
	public String updateEmp(@ModelAttribute Employee emp) {
		emps.updateEmp(emp);
		return "redirect:/employeeList";
	}
	@GetMapping("/deleteEmp")
	public String deleteEmp(@RequestParam long id) {
		emps.deleteEmp(id);
		return "redirect:/employeeList";
	}
	
}

