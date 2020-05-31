package com.example.furnitureshop.config;

import com.example.furnitureshop.model.UserRole;
import com.example.furnitureshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Base64;

@Component
public class UserAuthentication {
    private final UserService userService;

    @Autowired
    public UserAuthentication(UserService userService) {
        this.userService = userService;
    }

    public boolean hasAdminRole(String auth) {
        if (!StringUtils.isEmpty(auth)) {
            String username = this.getUsername(auth);
            if (!StringUtils.isEmpty(username)) {
                return userService.getByUsername(username)
                        .getUserRoles()
                        .stream()
                        .anyMatch(e -> e.getUserType().equals(UserRole.UserType.ROLE_ADMIN));
            }
        }
        return false;
    }

    public String getUsername(String auth) {
        String authToken = auth.substring("Basic".length()).trim();
        return new String(Base64.getDecoder()
                .decode(authToken)).split(":")[0];
    }
}
