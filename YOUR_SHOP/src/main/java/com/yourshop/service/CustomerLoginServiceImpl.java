package com.yourshop.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.modelmapper.internal.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourshop.dto.CustomerLoginDTO;
import com.yourshop.exception.LoginException;
import com.yourshop.model.CurrentCustomerSession;
import com.yourshop.model.Customer;
import com.yourshop.repository.CustomerRepo;
import com.yourshop.repository.CustomerSessionRepo;


@Service
public class CustomerLoginServiceImpl implements CustomerLoginService{
	
	
	@Autowired
	private CustomerRepo cRepo;
	
	@Autowired
	private CustomerSessionRepo csRepo;

	@Override
	public String logIntoAccount(CustomerLoginDTO dto) throws LoginException {


		Customer existingCustomer = cRepo.findByEmail(dto.getEmail());

		if (existingCustomer == null) 
		{
			throw new LoginException("Please enter a valid email");
		}

		Optional<CurrentCustomerSession> validCustomerSessionOpt = csRepo.findById(existingCustomer.getCustomerId());

		if (validCustomerSessionOpt.isPresent()) 
		{
			throw new LoginException("User already logged in with this email");
		}

		if (existingCustomer.getPassword().equals(dto.getPassword())) 
		{
			String key = RandomString.make(6);

			CurrentCustomerSession currentUserSession = new CurrentCustomerSession(existingCustomer.getCustomerId(), key,
					LocalDateTime.now());

			csRepo.save(currentUserSession);

			return currentUserSession.toString();
		} 
		else
		{
			throw new LoginException("Please enter a valid password");
		}
	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {


		CurrentCustomerSession validCustomerSession = csRepo.findByUuid(key);

		if (validCustomerSession == null) {
			throw new LoginException("User not logged in with this email");

		}

		csRepo.delete(validCustomerSession);

		return "logged out";
	}

}
