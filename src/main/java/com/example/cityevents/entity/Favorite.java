//package com.example.cityevents.entity;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "favorites")
//public class Favorite {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//
//    private Long id;
//    @ManyToOne
//    @JoinColumn(name="id_user")
//    private User11 user;
//    @ManyToOne
//    @JoinColumn(name = "id_event")
//    private Event event;
//    @Column(name="is_favorite")
//    private  boolean isFavorite;
//
//    public Favorite() {
//    }
//
//    public Favorite(Long id, User11 user, Event event, boolean isFavorite) {
//        this.id = id;
//        this.user = user;
//        this.event = event;
//        this.isFavorite = isFavorite;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public boolean isFavorite() {
//        return isFavorite;
//    }
//
//    public void setFavorite(boolean favorite) {
//        isFavorite = favorite;
//    }
//}
