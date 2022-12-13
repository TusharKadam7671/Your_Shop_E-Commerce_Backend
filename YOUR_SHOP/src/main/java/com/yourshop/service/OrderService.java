package com.yourshop.service;

import java.time.LocalDate;
import java.util.List;

import com.yourshop.exception.AddressException;
import com.yourshop.exception.CartException;
import com.yourshop.exception.LoginException;
import com.yourshop.exception.OrderException;
import com.yourshop.model.Orders;

public interface OrderService {
	
	public Orders addOrder(Orders order, String key) throws OrderException, CartException, LoginException;
	
	public Orders updateOrders(Orders order, String key)throws OrderException, LoginException;
	
	public Orders removeOrders(Integer orderId, String key)throws OrderException, LoginException;
	
	public Orders viewOrder(Integer orderId)throws OrderException;
	
	public List<Orders> viewAllOrders(LocalDate date) throws OrderException ;
	
	public List<Orders> viewAllOrdersByLocation(String city) throws OrderException,AddressException ;
	
	public List<Orders> viewAllOrdersByuserId(String mobileNumber) throws OrderException ;


}
