package com.example.furnitureshop.services;

import com.example.furnitureshop.exceptions.EmptyCartException;
import com.example.furnitureshop.model.*;
import com.example.furnitureshop.repositories.CartRepository;
import com.example.furnitureshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final OrderService orderService;

    @Value("Cart can not be empty")
    private String cartEmptyException;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, UserRepository userRepository, OrderService orderService) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.orderService = orderService;
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
    public void addToCart(String username, Furniture furniture, Long amount) {
        Cart cart = cartRepository.findByUser(userRepository.findUserByUsername(username));
        if (cart != null) {
            CartItem cartItem = cart.getCartItems()
                    .stream()
                    .filter(e -> e.getFurniture().getId().equals(furniture.getId()))
                    .findFirst()
                    .orElse(null);
            if (cartItem == null) {
                cart.getCartItems().add(new CartItem(furniture, amount));
            } else
                cartItem.setAmount(cartItem.getAmount() + amount);
            cartRepository.save(cart);
        }
    }

    @Override
    @Transactional
    public Order makeOrder(String username) {
        Cart cart = cartRepository.findByUser(userRepository.findUserByUsername(username));
        if (cart != null) {
            if (cart.getCartItems().size() == 0) {
                throw new EmptyCartException(this.cartEmptyException);
            }

            Order order = new Order();
            order.setCartItems(cart.getCartItems());
            order.setOrderDate(new Date());
            order.setUser(userRepository.findUserByUsername(username));

            if (order != null) {
                cart.setCartItems(new ArrayList<>());
                cartRepository.save(cart);
                return orderService.create(order);
            }
        }
        return null;
    }

}
