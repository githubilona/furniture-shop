package com.example.furnitureshop.repositories;

import com.example.furnitureshop.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<UserRole, Long> {
    public UserRole findUserRoleByUserType(UserRole.UserType userType);
}
