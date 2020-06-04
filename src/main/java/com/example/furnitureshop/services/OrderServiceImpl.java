package com.example.furnitureshop.services;

import com.example.furnitureshop.dtos.OrderDTO;
import com.example.furnitureshop.mappers.OrderMapper;
import com.example.furnitureshop.model.Order;
import com.example.furnitureshop.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public Order create(Order order) {
        if (order != null) {
            return orderRepository.save(order);
        }
        return null;
    }

    @Override
    public List<OrderDTO> findAll(String username) {
        if (username != null && !username.isEmpty())
            return orderRepository.findAll()
                    .stream()
                    .filter(e -> e.getUser().getUsername().equals(username))
                    .map(orderMapper::orderToDTO)
                    .collect(Collectors.toList());
        return null;
    }
}
