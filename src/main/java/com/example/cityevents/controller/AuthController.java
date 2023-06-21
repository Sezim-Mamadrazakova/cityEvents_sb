package com.example.cityevents.controller;

import com.example.cityevents.entity.AuthenticationRequest;
import com.example.cityevents.entity.AuthenticationResponse;
import com.example.cityevents.entity.RegisterRequest;
import com.example.cityevents.exeption.ResourceNotFoundException;
import com.example.cityevents.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")

public class AuthController{
    Logger log= LoggerFactory.getLogger(AuthController.class);
    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        log.info("Getting register user");
        try{
            return ResponseEntity.ok(authenticationService.register(request));
        }catch (Exception e){
            log.error("User not registered");
            throw e;
        }


    }

    @PostMapping("/authenticate")

    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        log.info("Getting authenticate user");
        try{
            return ResponseEntity.ok(authenticationService.authenticated(request));
        }catch (Exception e){
            log.error("User not authenticated");
            throw e;
        }

    }

}
