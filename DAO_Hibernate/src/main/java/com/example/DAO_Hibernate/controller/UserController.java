package com.example.DAO_Hibernate.controller;

import com.example.DAO_Hibernate.model.User;
import com.example.DAO_Hibernate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/persons/by-city")
    public List<User> getPersonsByCity(@RequestParam String city) {
        return userRepository.findByCity(city);
    }
}