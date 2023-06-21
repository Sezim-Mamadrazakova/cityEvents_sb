package com.example.cityevents.service;

import com.example.cityevents.entity.User;
import com.example.cityevents.enums.Role;
import com.example.cityevents.repository.UserRepository;
import com.example.cityevents.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

import static com.example.cityevents.enums.City.Moscow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserTest {

    private final UserRepository userRepository=mock(UserRepository.class);


    @Test
    void findByEmailTest(){
        String email="diana@gmail.com";
        User user=new User(351L,"Diana",email,"7654",Moscow,Role.User);
        when(userRepository.findByEmail(email)).thenReturn(user);
        UserService userService=new UserService(userRepository);
        User result=userService.findByEmail(email);
        Assertions.assertEquals(user, result);

    }
    @Test
    void findByUserNameTest(){
        String userName="Diana";
        User user=new User(351L,"Diana","diana@gmail.com","7654",Moscow,Role.User);
        when(userRepository.findByUserName(userName)).thenReturn(user);
        UserService userService=new UserService(userRepository);
        User result=userService.findByUserName(userName);
        Assertions.assertEquals(user, result);

    }
    @Test
    void loadUserByUserNameTest(){
        String email="diana@gmail.com";
        User user=new User(351L,"Diana",email,"7654",Moscow,Role.User);
        when(userRepository.findByEmail(email)).thenReturn(user);
        UserService userService=new UserService(userRepository);
        UserDetails userDetails=userService.loadUserByUsername(email);
        Assertions.assertEquals(email,userDetails.getUsername());
        Assertions.assertEquals("7654",userDetails.getPassword());
        Assertions.assertEquals("User",userDetails.getAuthorities().iterator().next().getAuthority());
    }
}
