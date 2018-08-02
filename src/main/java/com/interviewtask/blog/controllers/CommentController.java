package com.interviewtask.blog.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.interviewtask.blog.repositories.CommentRepository;

public class CommentController {
	
	CommentRepository commentRepo;
	

	@RequestMapping(value = "/admin/removeComment/{commentID}", method = RequestMethod.GET)
	public String removeComment(@PathVariable(value = "commentID") Long commentID){
		commentRepo.deleteById(commentID);
		return "redirect:/";
	}

}
