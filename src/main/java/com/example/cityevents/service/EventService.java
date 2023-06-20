package com.example.cityevents.service;

import com.example.cityevents.entity.Event;
import com.example.cityevents.exeption.ResourceNotFoundException;
import com.example.cityevents.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EventService {
    private static final Logger log= LoggerFactory.getLogger(EventService.class);
    public final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Optional<Event> findByEventName(final String eventName) {
        log.info("Getting event by name: "+eventName);
        return Optional.ofNullable(eventRepository.findByEventName(eventName)
                .orElseThrow(() -> {
                    log.error("Event not found for name: {}" , eventName);
                    return new ResourceNotFoundException("Event not found");
                }));
    }

    public List<Event> findAll() {
        log.info("Getting all events");
        try{
            return eventRepository.findAll();
        }catch (Exception e){
            log.error("Events not found");
            throw new ResourceNotFoundException("Events not found");
        }
    }
    public Event save(Event event){
        log.info("Creating event");
        try{
            return eventRepository.save(event);
        }catch (Exception e){
            log.error("Event not saved");
            throw e;
        }
    }
    public void delete(Long id){
        log.info("Deleting event");
        try{
            eventRepository.deleteById(id);
        }catch (Exception e){
            log.error("Event not deleted");
            throw e;
        }
    }
//    public void update(Event event){
//        log.info("Updating event with ID: {}",event.getId());
//        try {
//            eventRepository.update(event);
//        }catch (Exception e){
//            log.error("Event not updated");
//            throw e;
//        }
//
//    }

}
