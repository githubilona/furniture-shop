package com.example.furnitureshop.controllers;

import com.example.furnitureshop.config.UserAuthentication;
import com.example.furnitureshop.dtos.CartDTO;
import com.example.furnitureshop.model.Furniture;
import com.example.furnitureshop.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {
    private final CartService cartService;

    private final UserAuthentication userAuthentication;

    @Autowired
    public CartController(CartService cartService, UserAuthentication userAuthentication) {
        this.cartService = cartService;
        this.userAuthentication = userAuthentication;
    }

    @GetMapping
    public CartDTO getCart(@RequestHeader("Authorization") String auth) {
        return new CartDTO(cartService.getCart(userAuthentication.getUsername(auth)).getCartItems());
    }

    @PostMapping("/{id}")
    public CartDTO addToCart(@RequestHeader("Authorization") String auth,
                             @PathVariable(name = "id") Furniture furniture,
                             @RequestParam(name = "amount", required = false, defaultValue = "1") Long amount) {
        String username = userAuthentication.getUsername(auth);
        cartService.addToCart(username, furniture, amount);
        return new CartDTO(cartService.getCart(username).getCartItems());
    }

    @PutMapping
    public void makeOrder(@RequestHeader("Authorization") String auth) {
        String username = userAuthentication.getUsername(auth);
        cartService.makeOrder(username);
    }


}
