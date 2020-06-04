package com.example.furnitureshop.controllers;

import com.example.furnitureshop.config.UserAuthentication;
import com.example.furnitureshop.dtos.OrderDTO;
import com.example.furnitureshop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = {"http://localhost:4200"})
public class OrderController {
    private final OrderService orderService;

    private final UserAuthentication userAuthentication;

    @Autowired
    public OrderController(OrderService orderService, UserAuthentication userAuthentication) {
        this.orderService = orderService;
        this.userAuthentication = userAuthentication;
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public List<OrderDTO> getOrders(@RequestHeader("Authorization") String auth) {
        return orderService.findAll(userAuthentication.getUsername(auth));
    }

//    @PutMapping("/{id}")
//    @PreAuthorize("isAuthenticated()")
//    public Order updateById(@PathVariable Long id) {
//        return orderService.updateById(id);
//    }
}
