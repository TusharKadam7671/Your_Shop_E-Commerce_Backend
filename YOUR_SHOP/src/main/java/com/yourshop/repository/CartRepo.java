package com.yourshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yourshop.model.Cart;
import com.yourshop.model.Customer;


@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>{
	
	public Cart findByCustomer(Customer customer);

}
