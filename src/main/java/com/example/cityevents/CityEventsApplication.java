package com.example.cityevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CityEventsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CityEventsApplication.class, args);
    }

}
