package com.example.furnitureshop.services;

import com.example.furnitureshop.model.Cart;
import com.example.furnitureshop.model.Furniture;
import com.example.furnitureshop.model.Order;
import com.example.furnitureshop.model.User;

public interface CartService {
    void createCart(User user);

    Cart getCart(String username);

    void addToCart(String username, Furniture furniture, Long amount);

    Order makeOrder(String username);
}
