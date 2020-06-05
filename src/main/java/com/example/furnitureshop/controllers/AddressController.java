package com.example.furnitureshop.controllers;

import com.example.furnitureshop.config.UserAuthentication;
import com.example.furnitureshop.dtos.AddressDTO;
import com.example.furnitureshop.services.AddressService;
import com.example.furnitureshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
@CrossOrigin(origins = {"http://localhost:4200"})
public class AddressController {
    private final AddressService addressService;

    private final UserService userService;

    private final UserAuthentication userAuthentication;

    @Autowired
    public AddressController(AddressService addressService, UserService userService, UserAuthentication userAuthentication) {
        this.addressService = addressService;
        this.userService = userService;
        this.userAuthentication = userAuthentication;
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public AddressDTO findOneByUser(@RequestHeader("Authorization") String auth) {
        return addressService.findOneByUser(userService.getByUsername(userAuthentication.getUsername(auth)));
    }

    @PutMapping
    @PreAuthorize("isAuthenticated()")
    public AddressDTO update(@RequestBody AddressDTO addressDTO, @RequestHeader("Authorization") String auth) {
        return addressService.update(userService.getByUsername(userAuthentication.getUsername(auth)).getAddress(), addressDTO);
    }
}
