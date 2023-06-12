package com.example.cityevents.repository;

import com.example.cityevents.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(final String userName);
    Optional<User> findByEmail(final String email);


}
