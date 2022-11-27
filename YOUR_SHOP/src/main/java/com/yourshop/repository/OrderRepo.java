package com.yourshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourshop.model.OrderDetails;

public interface OrderRepo extends JpaRepository<OrderDetails, Integer>{

}
