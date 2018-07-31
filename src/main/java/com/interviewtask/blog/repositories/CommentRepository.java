package com.interviewtask.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.interviewtask.blog.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	Long countByPostid(String post_id);
	
	@Query(value = "select * from comments where postid = ?1 ORDER BY id DESC", nativeQuery = true)
	public List<Comment> findAllByPostID(Long post_id);
	
	@Modifying
	@Transactional
	@Query(value = "delete from comments where postid = ?1", nativeQuery = true)
	public void deleteAllComentsByPostID(Long post_id);

}
