package com.broadway.springproject.comtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.broadway.springproject.model.User;
import com.broadway.springproject.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService us;
	@GetMapping({"/","/login"})
	public String getLogin() {
		return "LoginForm";
	}
	@GetMapping("/signup")
	public String getSignUp() {
		return "SignUp";
	}
	
	@PostMapping("/signup")
	public String postSignUp(@ModelAttribute User user) {
		us.userSignup(user);
		return "LoginForm";
	}
	
	@PostMapping("/login")
	public String postLogin(@ModelAttribute User user,Model model) {
		User u=us.userLogin(user.getUsername(), user.getPassword());
		if(u!=null) {
			model.addAttribute("uname",user.getUsername());
			return "Home";
		}
		model.addAttribute("error","User Not Found");
		return "LoginForm";
		
	}

}
