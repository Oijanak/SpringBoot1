package com.broadway.springproject.comtroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.broadway.springproject.util.MailUtil;

@Controller
public class MailController  {
	@Autowired
	private MailUtil mailutil;
	@GetMapping("/contact")
	public String mail(HttpSession session) {
		if(session.getAttribute("activeuser")==null) {
			return "LoginForm";
		}
		return "EmailForm";
	}
	@PostMapping("/contact")
	public String sendMail(@RequestParam String toEmail,@RequestParam String subject,@RequestParam String message) {
		mailutil.sendEmail(toEmail,subject,message);
		return "EmailForm";
	}
}
