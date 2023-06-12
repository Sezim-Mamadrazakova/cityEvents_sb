package com.example.cityevents.repository;

import com.example.cityevents.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {

    Event findByEventName(String name);
    List<Event> findAll();
}