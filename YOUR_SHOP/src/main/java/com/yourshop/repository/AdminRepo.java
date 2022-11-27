package com.yourshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourshop.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>{

	Admin findByAdminId(Integer adminId);
	
}
