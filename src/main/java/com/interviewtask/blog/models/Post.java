package com.interviewtask.blog.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="posts")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String title;
	@Column(columnDefinition = "TEXT")	
	private String content;
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date datePosted = new Date();
	@Column(columnDefinition = "BIT")
	private Boolean edited;
	@Column
	private Integer commentCount = 0;
	
	public Post() {
	}
	
	
	
	public Boolean getEdited() {
		return edited;
	}



	public void setEdited(Boolean edited) {
		this.edited = edited;
	}



	public Integer getCommentCount() {
		return commentCount;
	}



	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDatePosted() {
		return datePosted;
	}
	public void setDatePosted(Date date) {
		this.datePosted = date;
	}
	
	

}
