package com.yourshop.service;

import com.yourshop.dto.CustomerLoginDTO;
import com.yourshop.exception.LoginException;

public interface CustomerLoginService {
	
	public String logIntoAccount(CustomerLoginDTO dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;

}
