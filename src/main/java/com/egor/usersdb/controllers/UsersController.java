package com.egor.usersdb.controllers;

import com.egor.usersdb.entities.UsersEntity;
import com.egor.usersdb.repositories.UsersRepository;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
    private UsersRepository repository;

    public UsersController(UsersRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/add")
    public UsersEntity add(@RequestBody UsersEntity users) {
        return repository.save(users);
    }

    @GetMapping("/get")
    public UsersEntity get(Authentication authentication) {
        return repository.findByUserName(authentication.getName());
    }
}
