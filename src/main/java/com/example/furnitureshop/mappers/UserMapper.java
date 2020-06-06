package com.example.furnitureshop.mappers;

import com.example.furnitureshop.dtos.UserDTO;
import com.example.furnitureshop.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User DTOtoUser(UserDTO userDTO);

    UserDTO UserToDTO(User user);
}