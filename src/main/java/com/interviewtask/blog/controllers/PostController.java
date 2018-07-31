package com.interviewtask.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.interviewtask.blog.models.Comment;
import com.interviewtask.blog.models.Post;
import com.interviewtask.blog.repositories.CommentRepository;
import com.interviewtask.blog.repositories.PostRepository;

@Controller
public class PostController {

	@Autowired
	PostRepository postRepo;
	
	@Autowired
	CommentRepository commentRepo;
	
	@RequestMapping("/")
	public String showAllPosts(Model model) {
		model.addAttribute("posts",postRepo.findAllByOrderByIdDesc());
		return "index";
	}
	
	@RequestMapping("/posts/{postID}")
	public String getPostByID(@PathVariable(value = "postID") Long postID,
			Model model) {
		try {
			model.addAttribute("post", postRepo.findById(postID).get());
			model.addAttribute("comments",commentRepo.findAllByPostID(postID));
			model.addAttribute("newcomment", new Comment());
		}catch(Exception e){
			return "index";
		}
		
		
		return "post";
}
	
	@GetMapping("/admin/addPost")
	public String addPostView(Model model) {
		model.addAttribute("post", new Post());
		return "admin/addpost";
	}
	
	@PostMapping("/admin/addPost")
	public String addPostFormProcess(Post post) {
		postRepo.save(post);
		return "redirect:/";
	}
	
	@PostMapping("/addComment")
	public String addCommentToPost(Comment comment) {
		commentRepo.save(comment);
		return "redirect:/posts/" + comment.getPostid().toString();
	}

	
}
