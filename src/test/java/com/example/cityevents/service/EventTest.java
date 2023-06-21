package com.example.cityevents.service;

import com.example.cityevents.entity.Event;
import com.example.cityevents.repository.EventRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class EventTest {
    EventRepository eventRepository=mock(EventRepository.class);
    EventService eventService=new EventService(eventRepository);
    @Test
    public void findByEventNameTest(){
        String name="ABS";
        Event event=new Event();
        event.setEventName(name);
        when(eventRepository.findByEventName(name)).thenReturn(Optional.of(event));
        Optional<Event> result=eventService.findByEventName(name);
        Assertions.assertEquals(event, result.get());

    }
    @Test
    public void findAllTest(){
        List<Event> events=new ArrayList<>();
        events.add(new Event());
        events.add(new Event());
        when(eventRepository.findAll()).thenReturn(events);
        List<Event> result=eventService.findAll();
        Assertions.assertEquals(events,result);
        Assertions.assertEquals(events.size(),result.size());
    }
    @Test
    public void saveTest(){
        LocalDate date= LocalDate.parse("2023-12-12");
        Event event=new Event(1L,"ABS","Backeer street 34",date,"18:00","120m");
        when(eventRepository.save(event)).thenReturn(event);
        eventService.save(event);
        verify(eventRepository,times(1)).save(event);

    }
    @Test
    public void deleteTest(){
        LocalDate date= LocalDate.parse("2023-12-12");
        Event event=new Event(1L,"ABS","Backeer street 34",date,"18:00","120m");
        when(eventRepository.findById(1L)).thenReturn(Optional.of(event));
        eventService.delete(1L);
        verify(eventRepository,times(1)).deleteById(1L);

    }
}
