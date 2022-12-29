package com.yourshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourshop.dto.ProductDto;

public interface ProductDtoRepo extends JpaRepository<ProductDto, Integer>{

}
