package com.yourshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yourshop.exception.AddressException;
import com.yourshop.exception.LoginException;
import com.yourshop.model.Address;
import com.yourshop.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	private AddressService aService;
	
	
	@PostMapping("/address")
	public ResponseEntity<Address> registerAddress(@RequestBody Address address,@RequestParam String loginKey) throws AddressException, LoginException{
		
		Address savedAddress=aService.addAddress(address, loginKey);
		
		return new ResponseEntity<Address>(savedAddress, HttpStatus.CREATED);
	}
	
	//================================================
	
//	 @PostMapping("/address")
//	    public ResponseEntity<Address> addAddressHandler(@Valid @RequestBody Address address ,@RequestParam String key) throws AddressException, LoginException {
//
//	        Address addAddresses = aService.addAddress(address, key);
//
//
//	        return new ResponseEntity<Address>(addAddresses, HttpStatus.OK);
//
//	    }
	
	//================================================
	
	
	@PutMapping("/address")
	public ResponseEntity<Address> updateAddressHandler(@RequestBody Address address,@RequestParam String loginkey) throws AddressException, LoginException{
		
		Address updateAddress=aService.updateAddress(address,loginkey);
		
		return new ResponseEntity<Address>(updateAddress,HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	@DeleteMapping("/address/{addressId}")
	public ResponseEntity<Address> deleteAddressByIdHandler(@PathVariable("addressId")Integer addressId) throws AddressException{
		
		Address delAddress=aService.deleteAddressId(addressId);
		
		return new ResponseEntity<Address>(delAddress,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/address")
	public ResponseEntity<List<Address>> getAllAddressHandler() throws AddressException {
		
		List<Address> address=aService.getAllAddress();
		
		return new ResponseEntity<List<Address>>(address,HttpStatus.OK);
	}
	
	
	@GetMapping("/getaddress/{addressId}")
	public ResponseEntity<Address> getAddressByIdHandler(@PathVariable("addressId")Integer addressId) throws AddressException{
		
		Address existingAddress= aService.viewAddressById(addressId);
		
		return new ResponseEntity<Address>(existingAddress,HttpStatus.OK);
	}
}
