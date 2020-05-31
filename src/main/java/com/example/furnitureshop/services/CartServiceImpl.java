package com.example.furnitureshop.services;

import com.example.furnitureshop.model.Cart;
import com.example.furnitureshop.model.Furniture;
import com.example.furnitureshop.model.User;
import com.example.furnitureshop.repositories.CartRepository;
import com.example.furnitureshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createCart(User user) {
        if (cartRepository.findByUser(userRepository.findUserByUsername(user.getUsername())) == null) {
            Cart cart = new Cart();
            cart.setCartItems(new ArrayList<>());
            cart.setUser(user);
            cartRepository.save(cart);
        }
    }

    @Override
    public Cart getCart(String username) {
        Cart cart = cartRepository.findByUser(userRepository.findUserByUsername(username));
        if (cart != null) {
            return cart;
        }
        return null;
    }

    @Override
    public void addToCart(String username, Furniture furniture, int amount) {

    }
}
