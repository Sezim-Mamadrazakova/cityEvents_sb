package com.example.cityevents.controller;

import com.example.cityevents.entity.Event;
import com.example.cityevents.service.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/event")
@CacheConfig(cacheNames = {"event"})
public class EventController {
    Logger log= LoggerFactory.getLogger(EventController.class);
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    @GetMapping("/all")
    @Cacheable()
    public ResponseEntity<List<Event>> findAll(){
        log.info("Getting all events");
        try {
            List<Event> eventList = eventService.findAll();
            return  ResponseEntity.ok(eventList);
        }catch (Exception e){
            log.error("Events not found");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    @GetMapping("/{eventName}")
    @Cacheable(key="#eventName")
    public ResponseEntity<Optional<Event>> getByEventName(@PathVariable("eventName") String eventName){
        log.info("Getting event by name: {}", eventName);
        try{
            Optional<Event> event= eventService.findByEventName(eventName);
            if(event.isPresent()){
                return  ResponseEntity.ok(event);
            }
            else {
                return ResponseEntity.notFound().build();
            }
        }catch (Exception e){
            log.error("Event not found for name: {}",eventName);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    @PostMapping("/create")
    public ResponseEntity<Event> createEvent(@RequestBody Event event){
        log.info("Creating new event: {}",event);
        try{
            Event created=eventService.save(event);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        }catch (Exception e){
            log.error("Event not saved");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @DeleteMapping("/delete/{id}")
    @CacheEvict(key="#id")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id){
        log.info("Deleting event by ID: {}", id);
        try{
            eventService.delete(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            log.error("Event not deleted");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
//    @PutMapping("/update")
//    public ResponseEntity<Event> updateEvent(@RequestBody Event event){
//        log.info("Updating event by name: {}", event.getEventName());
//        try{
//            eventService.update(event);
//            return ResponseEntity.ok(event);
//        }catch (Exception e){
//            log.error("Event not updated");
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }






}
