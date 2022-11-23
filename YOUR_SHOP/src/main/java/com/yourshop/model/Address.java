package com.yourshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	
	@NonNull
	@NotBlank(message = "Building name is mandatory")
	private String buildingName;
	
	@NonNull
	@NotBlank(message = "Street name is mandatory")
	private String StreetName;
	
	@NonNull
	@NotBlank(message = "City name is mandatory")
	private String city;
	
	@NonNull
	@NotBlank(message = "State name is mandatory")
	private String state;
	
	@NonNull
	@NotBlank(message = "Country name is mandatory")
	private String country;
	
	@Size(min = 6, max = 6, message = "pincode must be 6 digit ")
	private String pincode;
	
	@OneToOne
	private Customer customer;

}
