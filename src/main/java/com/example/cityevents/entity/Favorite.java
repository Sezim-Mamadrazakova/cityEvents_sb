package com.example.cityevents.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "favorites")
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @ManyToOne
    @JoinColumn(name="id_user")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id_event")
    private Event event;
    @Column(name="is_favorite")
    private  boolean isFavorite;


}
