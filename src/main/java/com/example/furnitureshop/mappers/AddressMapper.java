package com.example.furnitureshop.mappers;

import com.example.furnitureshop.dtos.AddressDTO;
import com.example.furnitureshop.model.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressDTO addressToDTO(Address address);

    Address DTOtoAddress(AddressDTO addressDTO);
}
