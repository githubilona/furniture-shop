package com.example.furnitureshop.services;

import com.example.furnitureshop.dtos.UserDTO;
import com.example.furnitureshop.model.User;

public interface UserService {
    User register(UserDTO userDTO);

    boolean login(String login, String password);
}
