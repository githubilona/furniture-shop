package com.example.furnitureshop.mappers;

import com.example.furnitureshop.dtos.OrderDTO;
import com.example.furnitureshop.model.Order;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order DTOtoOrder(OrderDTO orderDTO);

    OrderDTO orderToDTO(Order order);
}
