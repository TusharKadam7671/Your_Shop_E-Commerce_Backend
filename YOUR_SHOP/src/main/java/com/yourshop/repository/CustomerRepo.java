package com.yourshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yourshop.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	
	public Customer findByCustomerId(Integer customerId);
	
	public Customer findByEmail(String email);

}
