package com.interviewtask.blog.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String commenterName;
	@Column(columnDefinition = "TEXT")	
	private String content;
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date datePosted;
	@Column
	private Long postid;
	
	
	
	
	
	public Comment() {
		setDatePosted();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public void setDatePosted() {
		this.datePosted = new Date();
	}
	public String getCommenterName() {
		return commenterName;
	}
	public void setCommenterName(String commenterName) {
		this.commenterName = commenterName;
	}
	public Long getPostid() {
		return postid;
	}
	public void setPostid(Long postid) {
		this.postid = postid;
	}
	
	

}
