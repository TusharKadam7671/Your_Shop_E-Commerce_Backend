package com.yourshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yourshop.model.CurrentCustomerSession;


@Repository
public interface CustomerSessionRepo extends JpaRepository<CurrentCustomerSession, Integer>{

	public CurrentCustomerSession findByUuid(String uuid);
}
