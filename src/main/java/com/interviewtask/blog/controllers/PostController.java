package com.interviewtask.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@PostMapping("/addComment")
	public String addCommentToPost(Comment comment) {
		commentRepo.save(comment);
		Post tmp = postRepo.findById(comment.getPostid()).get();
		if(tmp.getCommentCount()==null) {
			tmp.setCommentCount(1);
		}else {
			tmp.setCommentCount(tmp.getCommentCount()+1);
		}
		
		postRepo.save(tmp);
		return "redirect:/posts/" + comment.getPostid().toString();
	}
	
	@GetMapping("/removeComment/{commentID}")
	public String removeComment(@PathVariable(value = "commentID") Long commentID){
		
		Comment comment = commentRepo.getOne(commentID);
		
		Post tmp = postRepo.findById(comment.getPostid()).get();
		if(tmp.getCommentCount()==null) {
			tmp.setCommentCount(0);
		}else {
			tmp.setCommentCount(tmp.getCommentCount()-1);
		}
			
		postRepo.save(tmp);
		commentRepo.deleteById(commentID);
		return "redirect:/";
	}
	
	
	
	@GetMapping("/admin/addPost")
	public String addPostView(Model model) {
		model.addAttribute("post", new Post());
		return "admin/addpost";
	}
	
	@PostMapping("/admin/addPost")
	public String addPostProcess(Post post) {
		postRepo.save(post);
		return "redirect:/";
	}
	
	
	
	@RequestMapping(value = "/admin/removePost/{postID}", method = RequestMethod.GET)
	public String removePost(@PathVariable(value = "postID") Long postID){
		commentRepo.deleteAllComentsByPostID(postID);
		postRepo.deleteById(postID);
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "/admin/editpost/{postID}", method = RequestMethod.GET)
	public String postEditView(@PathVariable(value = "postID") Long postID, Model model) {

		model.addAttribute("post",postRepo.findById(postID));
		return "admin/editpost";
	}
	

	@RequestMapping(value = "/admin/editpost", method = RequestMethod.POST)
	public String postEditProccess(Post post) {
		
		postRepo.save(post);

		return "redirect:/";
	}
	
	

	
}
