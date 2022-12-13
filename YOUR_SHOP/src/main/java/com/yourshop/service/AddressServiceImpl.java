package com.yourshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourshop.exception.AddressException;
import com.yourshop.exception.LoginException;
import com.yourshop.model.Address;
import com.yourshop.model.CurrentCustomerSession;
import com.yourshop.model.Customer;
import com.yourshop.repository.AddressRepo;
import com.yourshop.repository.CustomerRepo;
import com.yourshop.repository.CustomerSessionRepo;

@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private AddressRepo aDao;
	
	@Autowired
	CustomerRepo cDao;
	
	
	@Autowired
	CustomerSessionRepo sDao;
	
//	
	/*
	@Override
	public Address addAddress(Address address) throws AddressException {
		
		Address add=aDao.save(address);
		
		return add;
	}
	*/

	//===============================================================================
	
	@Override
	public Address addAddress(Address add, String key) throws AddressException, LoginException {
		
		Address	address= aDao.save(add);
		
		CurrentCustomerSession currentSession = sDao.findByUuid(key);
		
		Customer currentCustomer = cDao.findById(currentSession.getCurrentUserId()).get();
		
		if(currentCustomer == null)
		{
			throw new LoginException("Please do login!");
		}
		
		currentCustomer.setAddress(address);
			 
	 	        
	 	 cDao.save(currentCustomer);
	 	        
	 	 return address;
	        
	}
	
	//===============================================================================
	
	
	@Override
	public Address updateAddress(Address address) throws AddressException {
		
		Optional<Address> opt= aDao.findById(address.getAddressId());
		
		if(opt.isPresent()) {
			
			Address updatedAddress= aDao.save(address);
			return updatedAddress;
			
		}else
			throw new AddressException("Invalid Address details..");
	
	}



	@Override
	public Address deleteAddressId(Integer addressId) throws AddressException {
		
		Optional<Address> opt= aDao.findById(addressId);
		
		if(opt.isPresent()) {
			
			Address existingAddress= opt.get();
//			aDao.delete(existingAddress);
			aDao.deleteById(addressId);;
			
			return existingAddress;
			
			
		}else
			throw new AddressException("Address does not exist with Id :"+addressId);

	}



	@Override
	public List<Address> getAllAddress() throws AddressException {
		
		List<Address> address= aDao.findAll();
		
		if(address.size()==0)
			throw new AddressException("No Address is there");
		else
		return address;
	}



	@Override
	public Address viewAddressById(Integer addressId)throws AddressException {
		
		Optional<Address> opt=aDao.findById(addressId);
		
		if(opt.isPresent())
		{
			return opt.get();
		}
		else
			throw new AddressException("Address doesn't Exist");
	}



	
	

}
