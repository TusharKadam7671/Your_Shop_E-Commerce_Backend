package com.yourshop.service;

import java.util.List;

import com.yourshop.exception.AddressException;
import com.yourshop.exception.LoginException;
import com.yourshop.model.Address;

public interface AddressService {
	
	public Address addAddress(Address add, String key)throws AddressException, LoginException;
//	public Address addAddress(Address address)throws AddressException;
	
	public Address updateAddress(Address address)throws AddressException;
	
	public Address deleteAddressId(Integer addressId) throws AddressException;
	
	public List<Address> getAllAddress() throws AddressException;
	
	public Address viewAddressById(Integer addressId)throws AddressException;

}
