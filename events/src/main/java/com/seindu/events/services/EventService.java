package com.seindu.events.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seindu.events.models.Event;
import com.seindu.events.models.User;
import com.seindu.events.repositories.EventRepository;

@Service
public class EventService {
	@Autowired
	private EventRepository eRepo;
	
	//find all
	public List<Event> allEvents() {
		return this.eRepo.findAll();
	}
	
	// find event
	public Event findById(Long id) {
		return this.eRepo.findById(id).orElse(null);
	}
	
	// create
	public Event createEvent(Event event) {
		return this.eRepo.save(event);
	}
	
	//update
	public Event updateEvent(Event updateEvent) {
		return this.eRepo.save(updateEvent);
	}
	
	// delete
	public void deleteEvent(Long id) {
		this.eRepo.deleteById(id);
	}
	
	// find events by state
	public List<Event> eventByState(String state) {
		return this.eRepo.findByState(state);
	}
	
	// find out of state events
	public List<Event> eventOutOfState(String state) {
		return this.eRepo.findByStateIsNot(state);
	}
	
	// add attending users
	public void addAttendee(Event event, User user) {
		List<User> attendees = event.getAttendees();
		attendees.add(user);
		this.eRepo.save(event);
	}
	
	// remove attending users
	public void removeAttendee(Event event, User user) {
		List<User> attendees = event.getAttendees();
		attendees.remove(user);
		this.eRepo.save(event);
	}
	
}
