package com.yourshop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yourshop.exception.CustomerException;
import com.yourshop.model.Customer;
import com.yourshop.repository.CustomerSessionRepo;
import com.yourshop.service.CustomerService;


@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService cService;
	
	@Autowired
	private CustomerSessionRepo csRepo;
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer) throws CustomerException {

		Customer savedCustomer = cService.createCustomer(customer);

		return new ResponseEntity<Customer>(savedCustomer, HttpStatus.CREATED);
		
	}

}




	
	

	

	
