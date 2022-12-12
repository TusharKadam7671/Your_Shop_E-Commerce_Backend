package com.yourshop.model;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer catId;
	
	@NotNull(message = "Category name can not be null")
	@NotBlank(message = "Category name can not be blank")
	@NotEmpty(message = "Category name can not be empty")
	private String categoryName;
	
}
