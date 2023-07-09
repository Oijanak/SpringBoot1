package com.broadway.springproject.comtroller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GalleryController {
	@GetMapping("/gallery")
	public String getGallery( Model model,HttpSession session) {
		if(session.getAttribute("activeuser")==null) {
			return "LoginForm";
		}
		String[] imgNames=new File("src/main/resources/static/img").list();
		model.addAttribute("imgNameList",imgNames);
		return "GalleryFOrm";
	}
}
