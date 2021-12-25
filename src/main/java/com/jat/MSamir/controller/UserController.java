package com.jat.MSamir.controller;

import com.jat.MSamir.dao.UserRepository;
import com.jat.MSamir.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public @ResponseBody List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{userName}")
    public @ResponseBody User getUsers(@PathVariable String userName) {
        return userRepository.findByName(userName);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
