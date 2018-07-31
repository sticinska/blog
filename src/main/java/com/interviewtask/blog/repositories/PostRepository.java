package com.interviewtask.blog.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.interviewtask.blog.models.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long>{
	 public List<Post> findAllByOrderByIdDesc();
}
