package com.interviewtask.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.interviewtask.blog.repositories.PostRepository;

@Controller
public class PostController {

	@Autowired
	PostRepository postRepo;
	
	@RequestMapping("/")
	public String showAllPosts(Model model) {
		model.addAttribute("posts",postRepo.findAll());
		return "index";
	}
	
	
}
