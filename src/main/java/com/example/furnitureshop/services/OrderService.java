package com.example.furnitureshop.services;

import com.example.furnitureshop.dtos.OrderDTO;
import com.example.furnitureshop.model.Order;

import java.util.List;

public interface OrderService {
    Order create(Order order);
    List<OrderDTO> findAll(String username);
}
