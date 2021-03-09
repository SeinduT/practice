package com.seindu.events.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.seindu.events.models.Event;
import com.seindu.events.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
	List<Message> findByEvent(Event event);
}
