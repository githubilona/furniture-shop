package com.example.furnitureshop.dtos;

import com.example.furnitureshop.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressDTO {
    private String city;
    private String street;
    private String postCode;
    private String houseNumber;
    private String name;
    private String surname;
    private String phoneNumber;

    public AddressDTO(Address address) {
        this.city = address.getCity();
        this.street = address.getStreet();
        this.postCode = address.getPostCode();
        this.houseNumber = address.getHouseNumber();
        this.name = address.getName();
        this.surname = address.getSurname();
        this.phoneNumber = address.getPhoneNumber();
    }
}
