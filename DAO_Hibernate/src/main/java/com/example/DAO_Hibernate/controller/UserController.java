package com.example.DAO_Hibernate.controller;

import com.example.DAO_Hibernate.model.User;
import com.example.DAO_Hibernate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        updatedUser.setId(id);
        return userRepository.save(updatedUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/by-city")
    public List<User> getPersonsByCity(@RequestParam String city) {
        return userRepository.findByCity(city);
    }

    @GetMapping("/younger-than")
    public List<User> getUsersYoungerThan(@RequestParam int age) {
        return userRepository.findByAgeLessThanOrderByAgeAsc(age);
    }

    @GetMapping("/by-name-and-surname")
    public Optional<User> getUserByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return userRepository.findByNameAndSurname(name, surname);
    }
}