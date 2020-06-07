package com.example.furnitureshop.controllers;

import com.example.furnitureshop.config.UserAuthentication;
import com.example.furnitureshop.dtos.UserDTO;
import com.example.furnitureshop.mappers.UserMapper;
import com.example.furnitureshop.model.User;
import com.example.furnitureshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class UserController {

    private final UserService userService;
    private final UserAuthentication userAuthentication;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserAuthentication userAuthentication, UserMapper userMapper) {
        this.userService = userService;
        this.userAuthentication = userAuthentication;
        this.userMapper = userMapper;
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

    @GetMapping("/users")
    @Secured("ROLE_ADMIN")
    public List<UserDTO> getAll() {
        return userService.findAll();
    }

    @GetMapping("/user/profile")
    @PreAuthorize("isAuthenticated()")
    public UserDTO getCurrentUser(@RequestHeader("Authorization") String auth) {
        String username = userAuthentication.getUsername(auth);
        System.out.println(username);
        User user =userService.getByUsername(username);
        return userMapper.UserToDTO(user);
    }

    @PutMapping("/user/profile/{id}")
    @PreAuthorize("isAuthenticated()")
    public UserDTO update(@PathVariable("id") Long id,
                          @RequestBody UserDTO userDTO) {
        return userService.update(id, userDTO);
    }

    @GetMapping("/admin")
    @PreAuthorize("isAuthenticated()")
    public Boolean hasAdminRole(@RequestHeader("Authorization") String auth) {
        return userAuthentication.hasAdminRole(auth);
    }

    @DeleteMapping("/users/{id}")
    @Secured("ROLE_ADMIN")
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }
}
