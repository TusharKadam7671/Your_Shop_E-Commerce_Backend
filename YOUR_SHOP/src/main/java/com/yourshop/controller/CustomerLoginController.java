package com.yourshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yourshop.dto.CustomerLoginDTO;
import com.yourshop.exception.LoginException;
import com.yourshop.service.CustomerLoginService;


@RestController
@RequestMapping("/customer")
public class CustomerLoginController {
	
	
	@Autowired
	private CustomerLoginService clService;
	
	@PostMapping("/login")
	public ResponseEntity<String> logInCustomer(@RequestBody CustomerLoginDTO dto) throws LoginException {
		
		String result = clService.logIntoAccount(dto);
		

		
		return new ResponseEntity<String>(result,HttpStatus.OK );
		
		
	}
	
	@PostMapping("/logout")
	public String logoutCustomer(@RequestParam(required = false) String key) throws LoginException {
		
		return clService.logOutFromAccount(key);
		
	}

}
