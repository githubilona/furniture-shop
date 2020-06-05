package com.example.furnitureshop.repositories;

import com.example.furnitureshop.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
