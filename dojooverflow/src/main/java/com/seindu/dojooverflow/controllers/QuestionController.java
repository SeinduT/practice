package com.seindu.dojooverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.seindu.dojooverflow.models.Answer;
import com.seindu.dojooverflow.models.Question;
import com.seindu.dojooverflow.models.Tag;
import com.seindu.dojooverflow.services.AppService;

@Controller
public class QuestionController {
	@Autowired
	private AppService aService;
	
	@GetMapping("/")
	public String findAllQuestion(Model viewModel) {
		List<Question> questions = this.aService.findAllQuestions();
		viewModel.addAttribute("questions", questions);
		List<Tag> tags = this.aService.findAllTags();
		viewModel.addAttribute("tags", tags);
		return "question.jsp";
	}

	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("newQuestion") Question question) {
		return "index.jsp";
	}

	@PostMapping("/questions/new")
	public String createQuestion(@Valid @ModelAttribute("newQuestion") Question question, BindingResult result) {
		if (result.hasErrors()) {
			return "index.jsp";
		} 
		else {
			this.aService.createQuestion(question);
			return "redirect:/";
		}
	}

	@GetMapping("/questions/{id}")
	public String findQuestion(@PathVariable("id") Long id, Model model, @ModelAttribute("newAnswer") Answer answer, @ModelAttribute("newTag") Tag tag) {
		Question question = this.aService.findQuestion(id);
		model.addAttribute("question", question);
		return "show.jsp";
	}

	@PostMapping("/answers")
	public String createAnswer(@Valid @ModelAttribute("newAnswer") Answer answer, BindingResult result) {
		System.out.println(answer);
		if (result.hasErrors()) {
			return "show.jsp";
		} else {
			this.aService.createAnswer(answer);
			return "redirect:/";
		}

	}
	
	@PostMapping("/tags")
	public String createTag(@Valid @ModelAttribute("newTag") Tag tag, BindingResult result) {
		System.out.println(tag);
		if (result.hasErrors()) {
			return "show.jsp";
		}
		else {
			this.aService.createTag(tag);
			return "redirect:/";
		}
	}
	
}
