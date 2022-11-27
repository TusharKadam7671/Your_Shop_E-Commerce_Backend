package com.yourshop.service;

import java.util.List;

import com.yourshop.exception.ProductException;
import com.yourshop.model.Product;

public interface ProductService {
	
	public Product addProduct(Product product) throws ProductException;
	
	public Product updateProduct(Product product) throws ProductException;
	
	public Product viewProduct(int productId) throws ProductException;
	
	public List<Product> productByName(String name)throws ProductException;
	
	public List<Product> viewAllProducts() throws ProductException;
	
	public void removeProduct(int productId) throws ProductException;
	
	

}
