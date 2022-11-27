package com.yourshop.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
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
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	
	@Size(min = 3, message = "The product name should contain min 3 characters." )
	private String productName;
	
	@Min(value=1, message = "Please enter a valid value as a price.")
	private double price;
	
	private String color;
	
	private String dimension;
	
	private String manufacturer;
	
	@Min(value=1, message = "Please enter a valid quantity.")
	private int quantity;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;

	public Product(@Size(min = 3, message = "The product name should contain min 3 characters.") String productName,
			@Min(value = 1, message = "Please enter a valid value as a price.") double price, String color,
			String dimension, String manufacturer,
			@Min(value = 1, message = "Please enter a valid quantity.") int quantity, Category category) {
		super();
		this.productName = productName;
		this.price = price;
		this.color = color;
		this.dimension = dimension;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		this.category = category;
	}
	
	

}
