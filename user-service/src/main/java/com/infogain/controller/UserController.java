package com.infogain.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infogain.dto.UserDTO;
import com.infogain.service.IUserService;


@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private IUserService userService;
    
    @PostMapping
    public UserDTO createUser(@RequestBody @Valid UserDTO userDto) {
    	return userService.createUser(userDto);
    }
    
    @GetMapping
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }
    
    @GetMapping("/{userId}")
    public UserDTO getUsers(@PathVariable(name = "userId") Long userId){
        return userService.getUser(userId);
    }
    
    
    
}
