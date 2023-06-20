package com.example.cityevents.service;

import com.example.cityevents.entity.User;
import com.example.cityevents.exeption.ResourceNotFoundException;
import com.example.cityevents.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@CacheConfig(cacheNames ={"user"})

public class UserService implements UserDetailsService {
    private static final Logger log= LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User findByUserName(String userName){
        log.info("Getting user by name: "+userName);
        return userRepository.findByUserName(userName)
                .orElseThrow(()->{
                    log.error("User not found for name {}",userName);
                    return new ResourceNotFoundException("User not found");
                });

    }
    public User findByEmail(String email){
        log.error("Getting user by email: "+email);
        return userRepository.findByEmail(email)
                .orElseThrow(()->{
                    log.error("User not found for email: {}",email);
                    return new ResourceNotFoundException("User not found");
                });
    }


    @Override
    @Cacheable(key = "#email")
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("Loud user by email {}",email);
        User user=findByEmail(email);
        if(user==null){
            log.error("User id not found");
            throw new UsernameNotFoundException(String.format("User %s is not found", email));
        }

        UserDetails userDetails=User.builder()
                .userName(user.getUsername())
                .email(user.getEmail())
                .city(user.getCity())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
        return userDetails;
    }
}
