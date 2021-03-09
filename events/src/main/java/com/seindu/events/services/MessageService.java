package com.seindu.events.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seindu.events.models.Event;
import com.seindu.events.models.Message;
import com.seindu.events.models.User;
import com.seindu.events.repositories.MessageRepository;

@Service
public class MessageService {
	@Autowired
	private MessageRepository mRepo;
	
	public Message createMessage(Message message) {
		return this.mRepo.save(message);
	}
	
	public List<Message> getMessageByEvent(Event event) {
		return this.mRepo.findByEvent(event);
	}
	
	public void message(User user, Event event, String details) {
		this.mRepo.save(new Message(user, event, details));
	}
}
