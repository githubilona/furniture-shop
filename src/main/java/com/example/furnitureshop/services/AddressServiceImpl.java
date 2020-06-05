package com.example.furnitureshop.services;

import com.example.furnitureshop.dtos.AddressDTO;
import com.example.furnitureshop.mappers.AddressMapper;
import com.example.furnitureshop.model.Address;
import com.example.furnitureshop.model.User;
import com.example.furnitureshop.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    private final AddressMapper addressMapper;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository,
                              AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public AddressDTO findOneByUser(User user) {
        return addressMapper.addressToDTO(user.getAddress());
    }

    @Override
    public AddressDTO update(Address target, AddressDTO addressDTO) {
        if (target != null) {
            target.setCity(addressDTO.getCity().trim());
            target.setHouseNumber(addressDTO.getHouseNumber().trim());
            target.setName(addressDTO.getName().trim());
            target.setPhoneNumber(addressDTO.getPhoneNumber().trim());
            target.setPostCode(addressDTO.getPostCode().trim());
            target.setSurname(addressDTO.getSurname().trim());
            target.setStreet(addressDTO.getStreet().trim());
            addressRepository.save(target);
            return addressDTO;
        }
        return null;
    }

    @Override
    public boolean isAddressCorrect(Address address) {
        return !StringUtils.isEmpty(address.getCity())
                && !StringUtils.isEmpty(address.getHouseNumber())
                && !StringUtils.isEmpty(address.getName())
                && !StringUtils.isEmpty(address.getSurname())
                && !StringUtils.isEmpty(address.getPhoneNumber())
                && !StringUtils.isEmpty(address.getStreet())
                && !StringUtils.isEmpty(address.getClass())
                && !StringUtils.isEmpty(address.getPostCode());
    }

    @Override
    public Address create(AddressDTO addressDTO) {
        Address mapped = addressMapper.DTOtoAddress(addressDTO);
        return addressRepository.save(mapped == null ? new Address() : mapped);
    }


}
