package com.example.cityevents.controller;

import com.example.cityevents.entity.Event;
import com.example.cityevents.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api/event")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
    @GetMapping("/all")

    public String showAllEvent(Model model){
        model.addAttribute("events", eventService.findAll());
       return "events";
    }




}
