package com.broadway.springproject.comtroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.broadway.springproject.model.Department;
import com.broadway.springproject.service.DepartmentService;


@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService ds;
	@GetMapping("/department")
	public String department(HttpSession session) {
		if(session.getAttribute("activeuser")==null) {
			return "LoginForm";
		}
		return "department";
	} 
	@PostMapping("/department")
	public String addDepartment(@ModelAttribute Department d) {
		ds.addDepartment(d);
		return "Home";
	}
	@GetMapping("/departmentList")
	public String getAll(Model model,HttpSession session) {
		if(session.getAttribute("activeuser")==null) {
			return "LoginForm";
		}
		model.addAttribute("dlist",ds.getDepartment());
		return "DepartmentList";
	}
	@GetMapping("/edit")
	public String editDpt(@RequestParam int id,Model model) {
		model.addAttribute("dptmodel",ds.getDepartmentById(id));
		return "EditDepartment";
	}
	@PostMapping("/update")
	public String updateDpt(@ModelAttribute Department dept) {
		ds.addDepartment(dept);
		return "redirect:/departmentList";
	}
	
}
