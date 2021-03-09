package com.seindu.greatideas.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seindu.greatideas.models.Idea;
import com.seindu.greatideas.models.User;
import com.seindu.greatideas.services.IdeaService;
import com.seindu.greatideas.services.UserService;

@Controller
@RequestMapping("/ideas")
public class IdeaController {
	@Autowired
	private UserService uServ;
	@Autowired
	private IdeaService iServ;
	
	@GetMapping("")
	public String landing(HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("user_id");
		viewModel.addAttribute("ideas", this.iServ.getIdeas());
		viewModel.addAttribute("user", this.uServ.findUserById(userId));
		return "dashboard.jsp";
	}
	
	@GetMapping("/new")
	public String newIdea(@ModelAttribute("idea") Idea idea, HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("user_id");
		viewModel.addAttribute("user_id", userId);
		return "add.jsp";
	}
	
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, HttpSession session, Model viewModel) {
		if(result.hasErrors()) {
			Long userId = (Long)session.getAttribute("user_id");
			viewModel.addAttribute("user_id", userId);
			return "add.jsp";
		}
		this.iServ.create(idea);
		return "redirect:/ideas";
	}
	
	@GetMapping("/{id}")
	public String showIdea(@PathVariable("id")Long id, Model viewModel, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Idea idea = this.iServ.findById(id);
		if(userId == null) {
			return "redirect:/"; 
		}
		if(idea == null) {
			return "redirect:/ideas"; 
		} 
		viewModel.addAttribute("idea", idea);
		viewModel.addAttribute("user_id", userId);
		return "show.jsp"; 
	}
	
	@GetMapping("/edit/{id}")
	public String updateIdea(@PathVariable("id") Long id, HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("user_id");
		Idea idea = this.iServ.findById(id);
		if(userId == null) {
			return "redirect:/"; 
		}
		if(idea == null || !idea.getCreator().getId().equals(userId)) {
			return "redirect:/ideas"; 
		}
		viewModel.addAttribute("idea", idea);
		viewModel.addAttribute("user_id", userId);
		return "edit.jsp"; 
	}
	
	@PostMapping("edit/{id}")
	public String update(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, @PathVariable("id")Long id, HttpSession session, Model viewModel) {
		if(result.hasErrors()) {
			Long userId = (Long)session.getAttribute("user_id");
			viewModel.addAttribute("idea", idea);
			viewModel.addAttribute("user_id", userId);
			return "edit.jsp"; 
			
		}
		this.iServ.updateIdea(idea);
		return "redirect:/ideas"; 
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.iServ.deleteIdea(id);
		return "redirect:/ideas";
		}
	
	@GetMapping("/{id}/like")
	public String joinEvent(@PathVariable("id")Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Idea idea = this.iServ.findById(id);
		User userJoin = this.uServ.findUserById(userId);
		this.iServ.addLikedby(idea, userJoin);
		return "redirect:/ideas"; 
	}

	@GetMapping("/{id}/unLike")
	public String removeAttendee(@PathVariable("id")Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Idea idea = this.iServ.findById(id);
		User removeUser = this.uServ.findUserById(userId);
		this.iServ.removeLikedby(idea, removeUser);
		return "redirect:/ideas"; 
	}
}
