package com.yourshop.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDetails {
	
	@Id
	private Integer orderId;
	
	private LocalDate orderDate;
	
	private String orderStatus;
	
	@OneToOne
	private Customer customer;
	
	@OneToOne
	private Address address;
	
	@OneToMany
	private List<Product> productList = new ArrayList<>();

}
