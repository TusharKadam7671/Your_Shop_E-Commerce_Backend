package com.yourshop.service;

import com.yourshop.dto.AdminLoginDTO;
import com.yourshop.exception.LoginException;

public interface AdminLoginService {
	
	public String logIntoAccount(AdminLoginDTO dto) throws LoginException;
	
	public String logOutFromAccount(String key) throws LoginException;

}
