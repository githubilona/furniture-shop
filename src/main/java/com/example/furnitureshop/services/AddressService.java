package com.example.furnitureshop.services;

import com.example.furnitureshop.dtos.AddressDTO;
import com.example.furnitureshop.model.Address;
import com.example.furnitureshop.model.User;

public interface AddressService {
    AddressDTO findOneByUser(User user);

    AddressDTO update(Address target, AddressDTO addressDTO);

    boolean isAddressCorrect(Address address);

    Address create(AddressDTO addressDTO);
}
