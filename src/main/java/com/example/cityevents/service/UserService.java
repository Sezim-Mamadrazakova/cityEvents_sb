package com.example.cityevents.service;

import com.example.cityevents.entity.User;
import com.example.cityevents.exeption.ResourceNotFoundException;
import com.example.cityevents.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;





    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User findByUserName(String userName){
        return userRepository.findByUserName(userName)
                .orElseThrow(()->new ResourceNotFoundException("User not found"));

    }
    public User findByEmail(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("User not found"));
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user=findByEmail(email);
        if(user==null){
            throw new UsernameNotFoundException(String.format("User %s is not found", email));
        }
        return (UserDetails) user;
    }
}
