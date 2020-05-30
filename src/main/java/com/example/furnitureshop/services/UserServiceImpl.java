package com.example.furnitureshop.services;

import com.example.furnitureshop.dtos.UserDTO;
import com.example.furnitureshop.model.User;
import com.example.furnitureshop.model.UserRole;
import com.example.furnitureshop.repositories.RoleRepository;
import com.example.furnitureshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    @Override
    public User create(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(encoder.encode(userDTO.getPassword()));
        user.setEmail(userDTO.getEmail());
        user.setUserRoles(Collections.singleton(roleRepository.findUserRoleByUserType(UserRole.UserType.ROLE_USER)));
        return userRepository.save(user);
    }
}
