package com.example.cityevents.service;

import com.example.cityevents.entity.Event;
import com.example.cityevents.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    public final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public String findByEventName(final String eventName) {
        Event event = eventRepository.findByEventName(eventName);
        if (event != null) {
            return event.getEventName();
        }
        return null;
    }

    public List<Event> findAll() {
        List<Event> events = eventRepository.findAll();
        return events;
    }
}
