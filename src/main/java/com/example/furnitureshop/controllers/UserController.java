package com.example.furnitureshop.controllers;

import com.example.furnitureshop.dtos.UserDTO;
import com.example.furnitureshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody @Valid UserDTO userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return;
        }
        userService.register(userDTO);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody UserDTO userDTO) {
        return userService.login(userDTO.getUsername(), userDTO.getPassword());
    }
}
