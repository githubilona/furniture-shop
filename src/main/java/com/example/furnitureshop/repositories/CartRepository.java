package com.example.furnitureshop.repositories;

import com.example.furnitureshop.model.Cart;
import com.example.furnitureshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUser( User user);
}
