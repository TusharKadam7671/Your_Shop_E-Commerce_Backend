package com.yourshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourshop.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
