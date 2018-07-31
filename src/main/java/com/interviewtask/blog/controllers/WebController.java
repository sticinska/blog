package com.interviewtask.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {


	@RequestMapping("/about")
	public String showAllPosts(Model model) {
		return "about";
	}
}
