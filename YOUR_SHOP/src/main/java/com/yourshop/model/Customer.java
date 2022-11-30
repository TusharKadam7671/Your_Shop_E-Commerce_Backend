package com.yourshop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	@Size(min = 3, max = 15, message = "The first name should be min 3 and max of 15 characters.")
	private String firstName;
	
	@Size(min = 1, max = 15, message = "The last name should be min 1 and max of 15 characters.")
	private String lastName;
	
	@Size(min = 10, max = 10, message = "Mobile Number should contain 10 digit only")
	private String mobileNumber;
	
	@Email(message = "Please enter valid email address")
	private String email;
	
	@Size(min = 8, max = 16, message = "Password must contain min 8 and max 16 digits")
	private String password;
	
//	@OneToOne
	@JsonIgnore
	@OneToOne(mappedBy="customer", cascade = CascadeType.ALL)
	private Address address;
	
	@JsonIgnore
	@OneToOne(mappedBy="customer", cascade = CascadeType.ALL)
	private Cart cart;
	
//	@OneToMany
	@JsonIgnore
	@OneToMany(mappedBy="customer")
	private List<OrderDetails> orders = new ArrayList<>();

	public Customer(
			@Size(min = 3, max = 15, message = "The first name should be min 3 and max of 15 characters.") String firstName,
			@Size(min = 1, max = 15, message = "The last name should be min 1 and max of 15 characters.") String lastName,
			@Size(min = 10, max = 10, message = "Mobile Number should contain 10 digit only") String mobileNumber,
			@Email(message = "Please enter valid email address") String email,
			@Size(min = 8, max = 16, message = "Password must contain min 8 and max 16 digits") String password,
			Address address, Cart cart, List<OrderDetails> orders) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
		this.address = address;
		this.cart = cart;
		this.orders = orders;
	}
	
	

}
