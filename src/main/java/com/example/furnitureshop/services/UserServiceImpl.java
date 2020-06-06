package com.example.furnitureshop.services;

import com.example.furnitureshop.dtos.AddressDTO;
import com.example.furnitureshop.dtos.UserDTO;
import com.example.furnitureshop.exceptions.UserNotExistsException;
import com.example.furnitureshop.mappers.UserMapper;
import com.example.furnitureshop.model.User;
import com.example.furnitureshop.model.UserRole;
import com.example.furnitureshop.repositories.RoleRepository;
import com.example.furnitureshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;
    private final CartService cartService;
    private final AddressService addressService;
    private final UserMapper userMapper;


    @Value("user.not.exists")
    private String userNotExists;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder encoder, CartService cartService, AddressService addressService, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
        this.cartService = cartService;
        this.addressService = addressService;
        this.userMapper = userMapper;
    }

    @Override
    public User register(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(encoder.encode(userDTO.getPassword()));
        user.setEmail(userDTO.getEmail());
        user.setAddress(addressService.create(new AddressDTO()));
        user.setUserRoles(Collections.singleton(roleRepository.findUserRoleByUserType(UserRole.UserType.ROLE_USER)));
        userRepository.save(user);
        cartService.createCart(user);
        return user;
    }

    @Override
    public boolean login(String username, String password) {
        User u = userRepository.findUserByUsername(username);
        if (u == null) {
            return false;
        }
        return u.getUsername().equals(username)
                && encoder.matches(u.getUsername(), encoder.encode(password));
    }


    @Override
    public User getByUsername(String username) {
        if (!StringUtils.isEmpty(username)) {
            return userRepository.findUserByUsername(username);
        }
        return null;
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::UserToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO update(Long id, UserDTO userDTO) {
        userRepository.findById(id)
                .ifPresent(u -> {
                    u.setEmail(userDTO.getEmail());
                    u.setUsername(userDTO.getUsername());
                    u.setPassword(encoder.encode(userDTO.getPassword()));
                    userRepository.save(u);
                });
        return userRepository.findById(id)
                .map(userMapper::UserToDTO)
                .orElseThrow(() -> new UserNotExistsException(this.userNotExists));
    }



}
