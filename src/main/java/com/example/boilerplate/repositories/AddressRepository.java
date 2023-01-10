package com.example.boilerplate.repositories;

import com.example.boilerplate.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
