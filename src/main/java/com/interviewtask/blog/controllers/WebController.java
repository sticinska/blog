package com.interviewtask.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {


	@RequestMapping("/about")
	public String showAboutPage(Model model) {
		return "about";
	}
	
	@RequestMapping("/login")
	public String loginPage(Model model) {
		return "login";
	}
}
