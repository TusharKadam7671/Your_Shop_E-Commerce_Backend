package com.yourshop.service;

import com.yourshop.exception.AdminException;
import com.yourshop.model.Admin;

public interface AdminService {
	
	public Admin createAdmin(Admin admin) throws AdminException;

}
