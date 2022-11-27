package com.yourshop.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.modelmapper.internal.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourshop.dto.AdminLoginDTO;
import com.yourshop.exception.LoginException;
import com.yourshop.model.Admin;
import com.yourshop.model.CurrentAdminSession;
import com.yourshop.repository.AdminRepo;
import com.yourshop.repository.AdminSessionRepo;


@Service
public class AdminLoginServiceImpl implements AdminLoginService{

	@Autowired
	private AdminRepo aRepo;
	
	@Autowired
	private AdminSessionRepo asRepo;
	
	
	@Override
	public String logIntoAccount(AdminLoginDTO dto) throws LoginException {


		Optional<Admin> opt = aRepo.findById(dto.getAdminId());
		Admin existingAdmin = opt.get();
		
		if(existingAdmin == null)
		{
			throw new LoginException("Please enter a valid AdminId");
		}
		
		Optional<CurrentAdminSession> validAdminsessionOpt = asRepo.findById(existingAdmin.getAdminId());
		
		if(validAdminsessionOpt.isPresent())
		{
			throw new LoginException("Admin already logged in with this admin id");
		}
		
		if(existingAdmin.getAdminPass().equals(dto.getPassword()))
		{
			String key = RandomString.make(6);
			
			CurrentAdminSession currentAdminSession = new CurrentAdminSession(existingAdmin.getAdminId(), key, LocalDateTime.now());
			
			asRepo.save(currentAdminSession);
			
			return currentAdminSession.toString();
		}
		else
		{
			throw new LoginException("Please enter a valid admin password");
		}
	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {


		CurrentAdminSession validAdminSession = asRepo.findByUuid(key);

		if (validAdminSession == null) {
			throw new LoginException("Admin not logged in with this admin id");

		}

		asRepo.delete(validAdminSession);

		return "Admin logged out";

	}

}
