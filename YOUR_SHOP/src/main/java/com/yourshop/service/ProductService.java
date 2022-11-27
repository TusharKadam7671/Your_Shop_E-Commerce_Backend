package com.yourshop.service;

import java.util.List;

import com.yourshop.exception.CategoryException;
import com.yourshop.exception.ProductException;
import com.yourshop.model.Product;

public interface ProductService {
	
	public Product addProduct(Product product, int categoryId) throws ProductException, CategoryException;
	
	public Product updateProduct(Product product) throws ProductException;
	
	public Product viewProduct(int productId) throws ProductException;
	
	public List<Product> productByName(String name)throws ProductException;
	
	public List<Product> viewAllProducts() throws ProductException;
	
	public Product removeProduct(int productId, String key) throws ProductException;
	
	

}
