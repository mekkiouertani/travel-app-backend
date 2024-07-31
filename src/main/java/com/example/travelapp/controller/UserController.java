package com.example.travelapp.controller;

import com.example.travelapp.model.User;
import com.example.travelapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) {
        User foundUser = userRepository.findByUsername(user.getUsername());
        if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
            return foundUser;
        }
        return null; // Handle login failure appropriately
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return userRepository.findById(id);
    }
}