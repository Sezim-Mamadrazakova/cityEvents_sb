package com.example.cityevents.repository;

import com.example.cityevents.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public interface EventRepository extends JpaRepository<Event, Long> {

    Optional<Event> findByEventName(String name);
    void deleteById(Long id);


    //void update(Event event);
}
