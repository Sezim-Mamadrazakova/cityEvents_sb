package com.example.cityevents.entity;

import com.example.cityevents.enums.City;
import com.example.cityevents.enums.Role;

public class RegisterRequest {
    private String userName;
    private String email;
    private String password;
    private City city;
    private Role role;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public RegisterRequest(String userName, String email, String password, City city, Role role) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.city=city;
        this.role=role;
    }

    public RegisterRequest() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
