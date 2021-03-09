package com.seindu.dojooverflow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="questions")
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String question;
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Answer> relatedAnswers;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tags_questions", 
	joinColumns = @JoinColumn(name = "questions_id"), 
	inverseJoinColumns = @JoinColumn(name = "tags_id"))
	
	private List<Tag> tags;
	
	public Question() {
	}
	
	public Question(String question, List<Tag> tags) {
		this.question = question; 
		this.tags = tags; 
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Answer> getRelatedAnswers() {
		return relatedAnswers;
	}

	public void setRelatedAnswers(List<Answer> relatedAnswers) {
		this.relatedAnswers = relatedAnswers;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

}
