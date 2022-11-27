package com.yourshop.service;

import com.yourshop.exception.CustomerException;
import com.yourshop.model.Customer;

public interface CustomerService {
	
	public Customer createCustomer(Customer customer) throws CustomerException;

}
