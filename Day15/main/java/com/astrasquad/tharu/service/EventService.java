package com.astrasquad.tharu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.astrasquad.tharu.model.Event;
import com.astrasquad.tharu.repository.EventRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event createEvent(Event event) {
        // Implement logic to create and save an event
        return eventRepository.save(event);
    }

    public Event getEventById(Integer eventId) {
        // Implement logic to retrieve an event by ID
        Optional<Event> eventOptional = eventRepository.findById(eventId);
        return eventOptional.orElse(null);
    }

    public List<Event> getAllEvents() {
        // Implement logic to retrieve all events
        return eventRepository.findAll();
    }

    public Event updateEvent(Event event) {
        // Implement logic to update and save an event
        return eventRepository.save(event);
    }

    public void deleteEvent(Integer eventId) {
        // Implement logic to delete an event by ID
        eventRepository.deleteById(eventId);
    }
}
