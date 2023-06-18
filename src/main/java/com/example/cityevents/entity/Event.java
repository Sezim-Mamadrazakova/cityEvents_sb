package com.example.cityevents.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "events")
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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




}
