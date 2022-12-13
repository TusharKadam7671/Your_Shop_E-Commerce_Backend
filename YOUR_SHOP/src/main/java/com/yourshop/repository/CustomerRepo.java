package com.yourshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yourshop.exception.CustomerException;
import com.yourshop.model.Address;
import com.yourshop.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	
	public Customer findByCustomerId(Integer customerId);
	
	public Customer findByEmail(String email);
	
	public Customer findByMobileNumber(String mobileNo);
	
	public Customer findByAddress(Address address);
	
	@Query("select c from Customer c where c.address.city=?1")
	public List<Customer> getCustomerByCity(String location) throws CustomerException;

}
