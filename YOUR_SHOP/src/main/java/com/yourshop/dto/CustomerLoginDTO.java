package com.yourshop.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CustomerLoginDTO {
	
	private String mobileNo;
	private String Email;
	private String password;

}
