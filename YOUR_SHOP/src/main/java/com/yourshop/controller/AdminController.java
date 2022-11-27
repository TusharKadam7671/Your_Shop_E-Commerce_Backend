package com.yourshop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yourshop.exception.AdminException;
import com.yourshop.model.Admin;
import com.yourshop.repository.AdminSessionRepo;
import com.yourshop.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	
	@Autowired
	private AdminService aService;
	
	@Autowired
	private AdminSessionRepo asRepo;
	
	@PostMapping("/createadmin")
	public ResponseEntity<Admin> saveAdmin(@Valid @RequestBody Admin admin) throws AdminException {

		Admin savedAdmin = aService.createAdmin(admin);

		return new ResponseEntity<Admin>(savedAdmin, HttpStatus.CREATED);
	}

}
