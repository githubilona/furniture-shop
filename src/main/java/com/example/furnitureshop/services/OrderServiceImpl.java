package com.example.furnitureshop.services;

import com.example.furnitureshop.model.Order;
import com.example.furnitureshop.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order create(Order order) {
        if (order != null) {
            return orderRepository.save(order);
        }
        return null;
    }
}
