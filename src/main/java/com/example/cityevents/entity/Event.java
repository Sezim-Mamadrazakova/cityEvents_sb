package com.example.cityevents.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "event_name")
    private String eventName;
    @Column(name = "event_place")
    private String eventPlace;

    @Column(name = "date_start")
    private LocalDate dateStart;
    @Column(name = "time_start")
    private String timeStart;
    @Column(name = "duration_event")
    private String durationEvent;

    public Event() {
    }

    public Event(Long id, String eventName, String eventPlace, LocalDate dateStart, String timeStart, String durationEvent) {
        this.id = id;
        this.eventName = eventName;
        this.eventPlace = eventPlace;
        this.dateStart = dateStart;
        this.timeStart = timeStart;
        this.durationEvent = durationEvent;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventPlace() {
        return eventPlace;
    }

    public void setEventPlace(String eventPlace) {
        eventPlace = eventPlace;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getDurationEvent() {
        return durationEvent;
    }

    public void setDurationEvent(String durationEvent) {
        this.durationEvent = durationEvent;
    }
}
