package com.example.furnitureshop.dtos;

import com.example.furnitureshop.model.CartItem;
import com.example.furnitureshop.model.Order;
import com.example.furnitureshop.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long ID;
    private List<CartItem> cartItems;
    private Date orderDate;
    private User user;
    private Integer orderID;

    public OrderDTO(Order order) {
        this.ID = order.getId();
        this.cartItems = order.getCartItems();
        this.orderDate = order.getOrderDate();
        this.user = order.getUser();
    }
}
