package com.example.furnitureshop.services;

import com.example.furnitureshop.dtos.UserDTO;
import com.example.furnitureshop.model.User;

import java.util.List;

public interface UserService {
    User register(UserDTO userDTO);

    boolean login(String login, String password);

    User getByUsername(String username);

    List<UserDTO> findAll();

    UserDTO update(Long id, UserDTO userDTO);

    void delete(Long id);

}
