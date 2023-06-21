package com.example.cityevents.controller;

import com.example.cityevents.entity.Event;
import com.example.cityevents.service.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(summary = "Getting all events")
    @ApiResponse(responseCode = "200", description = "OK")
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
    @Operation(summary = "Getting event by name")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "Event not found")
    @GetMapping("/{eventName}")
    @Cacheable(key="#eventName")
    public ResponseEntity <Event> getByEventName(@PathVariable("eventName") String eventName){
        log.info("Getting event by name: {}", eventName);
        try{
            Event event= eventService.findByEventName(eventName);
            if(event!=null){
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
    @Operation(summary = "Create event ")
    @ApiResponse(responseCode = "201", description = "OK")
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
    @Operation(summary = "Deleting event by name")
    @ApiResponse(responseCode = "204", description = "OK")
    @ApiResponse(responseCode = "404", description = "Event not found")
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







}
