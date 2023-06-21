package com.example.cityevents.repository;

import com.example.cityevents.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(final String userName);
    User findByEmail(final String email);





}
