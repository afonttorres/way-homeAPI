package com.hackaton.wayhome.controllers;

import com.hackaton.wayhome.dtos.client.user.UserResDto;
import com.hackaton.wayhome.models.client.User;
import com.hackaton.wayhome.services.client.user.IUserService;
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
    ResponseEntity<List<UserResDto>> getAllUsers(){
        var users = userService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    ResponseEntity<UserResDto> getAllUsers(@PathVariable Long id){
        var user = userService.getById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
