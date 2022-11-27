package com.yourshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourshop.exception.AdminException;
import com.yourshop.model.Admin;
import com.yourshop.repository.AdminRepo;
import com.yourshop.repository.AdminSessionRepo;


@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepo aRepo;
	
	@Autowired
	private AdminSessionRepo asRepo;

	@Override
	public Admin createAdmin(Admin admin) throws AdminException {

		Admin existingAdmin = aRepo.findByAdminId(admin.getAdminId());
		
		if(existingAdmin != null)
		{
			throw new AdminException("Admin already registered with this Admin Id");
		}
		
		return aRepo.save(admin);
	}

}
