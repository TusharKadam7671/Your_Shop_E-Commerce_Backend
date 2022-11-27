package com.yourshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourshop.exception.CustomerException;
import com.yourshop.model.Customer;
import com.yourshop.repository.CustomerRepo;
import com.yourshop.repository.CustomerSessionRepo;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	
	@Autowired
	private CustomerRepo cRepo;
	
	
	@Autowired
	private CustomerSessionRepo csRepo;

	@Override
	public Customer createCustomer(Customer customer) throws CustomerException {


		Customer existingCustomer= cRepo.findByEmail(customer.getEmail());
		
		
		
		if(existingCustomer != null) 
			throw new CustomerException("Customer already registered with email");
			
		
		
		
			return cRepo.save(customer);
	}

}
