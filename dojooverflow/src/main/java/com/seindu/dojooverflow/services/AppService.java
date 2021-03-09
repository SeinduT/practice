package com.seindu.dojooverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.metrics.StartupStep.Tags;
import org.springframework.stereotype.Service;

import com.seindu.dojooverflow.models.Answer;
import com.seindu.dojooverflow.models.Question;
import com.seindu.dojooverflow.models.Tag;
import com.seindu.dojooverflow.repositories.AnswerRepository;
import com.seindu.dojooverflow.repositories.QuestionRepository;
import com.seindu.dojooverflow.repositories.TagRepository;

@Service
public class AppService {
	@Autowired
	private QuestionRepository qRepo;
	@Autowired
	private AnswerRepository aRepo;
	@Autowired
	private TagRepository tRepo;
	
	// Create question
	public Question createQuestion(Question question) {
		return this.qRepo.save(question);
	}
	
	// Create Answer
	public Answer createAnswer(Answer answer) {
		return this.aRepo.save(answer);
	}
	
	// Create Tag
	public Tag createTag(Tag tag) {
		return this.tRepo.save(tag);
	}
	
	// Find one question
	public Question findQuestion(Long id) {
		return this.qRepo.findById(id).orElse(null);
	}
	
	// Find one answer
	public Answer findAnswer(Long id) {
		return this.aRepo.findById(id).orElse(null);
	}
	
	// Find one tag
	public Tag findTag(Long id) {
		return this.tRepo.findById(id).orElse(null);
	}
	
	// Find all questions
	public List<Question> findAllQuestions() {
		return this.qRepo.findAll();
	}
	
	// Find all answers
	public List<Answer> findAllAnswers() {
		return this.aRepo.findAll();
	}
	
	// Find all tags
	public List<Tag> findAllTags() {
		return this.tRepo.findAll();
	}
	
	// Add tag to database
	public void addtag(Question question, Tag tag) {
		List<Tag> tags = question.getTags();
		tags.add(question);
		this.tRepo.save(tag); 
	}
}
