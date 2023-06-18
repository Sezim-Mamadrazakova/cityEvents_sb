package com.example.cityevents.entity;

import com.example.cityevents.enums.City;
import com.example.cityevents.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String userName;
    private String email;
    private String password;
    private City city;
    private Role role;

}
