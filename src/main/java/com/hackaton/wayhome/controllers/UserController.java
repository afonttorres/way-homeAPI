package com.hackaton.wayhome.controllers;

import com.hackaton.wayhome.models.User;
import com.hackaton.wayhome.services.user.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    IUserService userService;

    public UserController(IUserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    List<User> getAllUsers(){
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    ResponseEntity<User> getAllUsers(@PathVariable Long id){
        var user = userService.getById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
