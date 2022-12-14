package com.yourshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourshop.exception.CustomerException;
import com.yourshop.model.Customer;
import com.yourshop.repository.CustomerRepo;
import com.yourshop.repository.CustomerSessionRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo custDao;

	@Autowired
	private CustomerSessionRepo csRepo;

	@Override
	public Customer addCustomer(Customer cust) throws CustomerException 
	{
		Customer old = custDao.findByMobileNumber(cust.getMobileNumber());
		
		if (old != null) 
		{
			throw new CustomerException(
					"Customer is already registered with this mobile number: " + cust.getMobileNumber());
		}
		
		Customer add = custDao.save(cust);
		
		return add;
	}
	
	

	@Override
	public Customer updateCustomer(Customer cust) throws CustomerException 
	{
		Optional<Customer> opt = custDao.findById(cust.getCustomerId());
		
		if (opt.isPresent()) 
		{
			Customer updateCustomer = custDao.save(cust);
			return updateCustomer;
			
		} 
		else
		{
			throw new CustomerException("Invalid Customer Details Please Check");
		}
	}
	

	@Override
	public Customer removeCustomer(Integer cust) throws CustomerException 
	{
		Optional<Customer> opt = custDao.findById(cust);
		
		if (opt.isPresent()) 
		{
			Customer existingCustomer = opt.get();
			custDao.delete(existingCustomer);
			return existingCustomer;
			
		} 
		else
		{
			throw new CustomerException("Customer Does not exist with the id :" + cust);
		}
	}

	@Override
	public Customer viewCustomer(Integer Cust) throws CustomerException 
	{

		Optional<Customer> opt = custDao.findById(Cust);
		
		if (opt.isPresent()) 
		{
			return opt.get();
			
		} 
		else
		{
			throw new CustomerException("No Customer Found with the Given ID:" + Cust);
		}
	}

	

	@Override
	public List<Customer> viewAllCustomers(String location) throws CustomerException 
	{

//		List<Customer> customerList = custDao.getCustomerByCity(location);
		List<Customer> customerList = null;

		if (customerList.isEmpty()) 
		{
			throw new CustomerException("Customer not found in the location");
		}
		else
		{
			return customerList;
		}

	}

}
