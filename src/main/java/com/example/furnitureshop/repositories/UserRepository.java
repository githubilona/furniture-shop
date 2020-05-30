package com.example.furnitureshop.repositories;

import com.example.furnitureshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername ( String username );
}
