package com.yourshop.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AdminLoginDTO {
	
	
	private Integer adminId;
	private String password;

}
