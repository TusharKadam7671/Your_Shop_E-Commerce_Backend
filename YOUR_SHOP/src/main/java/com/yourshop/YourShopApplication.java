package com.yourshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class YourShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(YourShopApplication.class, args);
	}

}
