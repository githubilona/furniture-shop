package com.example.furnitureshop.config;

import com.example.furnitureshop.model.*;
import com.example.furnitureshop.repositories.CartRepository;
import com.example.furnitureshop.repositories.FurnitureRepository;
import com.example.furnitureshop.repositories.RoleRepository;
import com.example.furnitureshop.repositories.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

@Configuration
public class RepositoryInitializer {
    private final FurnitureRepository furnitureRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final CartRepository cartRepository;

    @Autowired
    public RepositoryInitializer(FurnitureRepository furnitureRepository, RoleRepository roleRepository, UserRepository userRepository, BCryptPasswordEncoder encoder, CartRepository cartRepository) {
        this.furnitureRepository = furnitureRepository;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.cartRepository = cartRepository;
    }

    @Bean
    public InitializingBean initializingBean() {
        return () -> {
            if (furnitureRepository.findAll().isEmpty()) {
                furnitureRepository.save( new Furniture("Krzesło","Opis1", "Producent1", new BigDecimal(200),11));
                furnitureRepository.save( new Furniture("Łóżko","Opis2", "Producent2", new BigDecimal(500),10));
                furnitureRepository.save( new Furniture("Stół","Opis3", "Producent3", new BigDecimal(400),9));
                furnitureRepository.save( new Furniture("Szafa","Opis4", "Producent4", new BigDecimal(800),15));
            }
            if (roleRepository.findAll().isEmpty()) {
                roleRepository.save(new UserRole(1L, UserRole.UserType.ROLE_USER));
                roleRepository.save(new UserRole(2L, UserRole.UserType.ROLE_ADMIN));
            }
            if (userRepository.findAll().isEmpty()) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(encoder.encode("admin"));
                admin.setEmail("admin@admin.pl");
                admin.setAddress(new Address());
                admin.setUserRoles(new HashSet<>(Arrays.asList(roleRepository.findUserRoleByUserType(UserRole.UserType.ROLE_ADMIN), roleRepository.findUserRoleByUserType(UserRole.UserType.ROLE_USER))));
                userRepository.save(admin);
                cartRepository.save(new Cart(1L, admin, new ArrayList<>()));

                User user = new User();
                user.setUsername("user");
                user.setPassword(encoder.encode("user"));
                user.setEmail("user@user.pl");
                user.setAddress(new Address());
                user.setUserRoles(new HashSet<>(Arrays.asList(roleRepository.findUserRoleByUserType(UserRole.UserType.ROLE_USER))));
                userRepository.save(user);
                cartRepository.save(new Cart(2L, user, new ArrayList<>()));
            }

        };
    }
}
