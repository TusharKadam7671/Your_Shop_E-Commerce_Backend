package com.yourshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yourshop.model.CurrentAdminSession;

public interface AdminSessionRepo extends JpaRepository<CurrentAdminSession, Integer>{

	public CurrentAdminSession findByUuid(String uuid);
}
