package com.yourshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourshop.model.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer>{

}
