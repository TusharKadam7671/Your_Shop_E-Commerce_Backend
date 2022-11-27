package com.yourshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourshop.model.Address;

public interface AddressRepo extends JpaRepository<Address, Integer>{

}
