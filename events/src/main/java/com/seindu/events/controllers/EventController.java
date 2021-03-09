package com.seindu.events.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.seindu.events.models.Event;
import com.seindu.events.models.State;
import com.seindu.events.models.User;
import com.seindu.events.services.EventService;
import com.seindu.events.services.MessageService;
import com.seindu.events.services.UserService;

@Controller
public class EventController {
	@Autowired
	private EventService eService;  
	@Autowired
	private UserService uService; 
	@Autowired
	private MessageService mService;
	
	
	@GetMapping("/events")
	public String loginIndex(Model model, HttpSession session, @ModelAttribute("event")Event event) {
		if(session.getAttribute("user_id").equals(null)) {
			return "redirect:/"; 
		}
		Long userId = (Long)session.getAttribute("user_id");
		User user = this.uService.findUserById(userId);
		model.addAttribute("user", user);
		model.addAttribute("states", State.States);
		model.addAttribute("allEvents", this.eService.eventByState(user.getState()));
		model.addAttribute("otherStates", this.eService.eventOutOfState(user.getState()));
		model.addAttribute("events", this.eService.allEvents());
		return "home.jsp"; 
		
	}
	
	@PostMapping("/newevent")
	public String createEvent(@Valid @ModelAttribute("event")Event event, BindingResult result, HttpSession session, Model model) {
		if(result.hasErrors()) {
			Long userId = (Long)session.getAttribute("user_id");
			User user = this.uService.findUserById(userId);
			model.addAttribute("user", this.uService.findUserById(userId));
			model.addAttribute("states", State.States);
			model.addAttribute("allEvents", this.eService.eventByState(user.getState()));
			model.addAttribute("otherStates", this.eService.eventOutOfState(user.getState()));
			model.addAttribute("events", this.eService.allEvents());
			return "home.jsp"; 
		}
		this.eService.createEvent(event);
		return "redirect:/events"; 
	}
	
		@GetMapping("/events/edit/{id}")
		public String updateEvent(@PathVariable("id") Long id, HttpSession session, Model model) {
			Long userId = (Long)session.getAttribute("user_id");
			Event event = this.eService.findById(id);
			if(userId == null) {
				return "redirect:/"; 
			}
			if(event == null || !event.getCreator().getId().equals(userId)) {
				return "redirect:/events"; 
			}
			model.addAttribute("event", event);
			model.addAttribute("states", State.States);
			model.addAttribute("user_id", userId);
			return "edit.jsp"; 
		}
		
		@PostMapping("/events/edit/{id}")
		public String update(@Valid @ModelAttribute("event")Event event, BindingResult result, @PathVariable("id")Long id, HttpSession session, Model model) {
			if(result.hasErrors()) {
				Long userId = (Long)session.getAttribute("user_id");
				model.addAttribute("event", event);
				model.addAttribute("states", State.States);
				model.addAttribute("user_id", userId);
				return "edit.jsp"; 
				
			}
			this.eService.updateEvent(event);
			return "redirect:/events"; 
		}
		
	@GetMapping("/events/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.eService.deleteEvent(id);
		return "redirect:/events";
		}
	
	@GetMapping("/events/{id}")
	public String showEvent(@PathVariable("id")Long id, Model model, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Event event = this.eService.findById(id);
		if(userId == null) {
			return "redirect:/"; 
		}
		if(event == null) {
			return "redirect:/events"; 
		} 
		model.addAttribute("event", event);
		model.addAttribute("user_id", userId);
		return "show.jsp"; 
	}
	
	@PostMapping("/comment/{id}")
	public String Comment(@PathVariable("id") Long id, @RequestParam("content") String content, RedirectAttributes redirs, HttpSession session) {
	Long userId = (Long)session.getAttribute("user_id");
	if(userId == null) {
		return "redirect:/"; 
	}
	if(content.equals("")) {
		redirs.addFlashAttribute("error", "Comment must not be blank.");
		return "redirect:/" + id; 
	}
	Event event = this.eService.findById(id);
	User user = this.uService.findUserById(userId);
	this.mService.message(user, event, content);
	return "redirect:/" + id; 
	}
	
@GetMapping("events/{id}/join")
public String joinEvent(@PathVariable("id")Long id, HttpSession session) {
	Long userId = (Long)session.getAttribute("user_id");
	Event event = this.eService.findById(id);
	User userJoin = this.uService.findUserById(userId);
	this.eService.addAttendee(event, userJoin);
	return "redirect:/events"; 
}

@GetMapping("events/{id}/cancel")
public String removeAttendee(@PathVariable("id")Long id, HttpSession session) {
	Long userId = (Long)session.getAttribute("user_id");
	Event event = this.eService.findById(id);
	User removeUser = this.uService.findUserById(userId);
	this.eService.removeAttendee(event, removeUser);
	return "redirect:/events"; 
}
}
