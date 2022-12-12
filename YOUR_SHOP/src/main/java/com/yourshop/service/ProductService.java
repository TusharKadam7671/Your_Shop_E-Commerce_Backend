package com.yourshop.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.yourshop.exception.CategoryException;
import com.yourshop.exception.ProductException;
import com.yourshop.model.Product;

public interface ProductService {
	
public List<Product> viewAllProducts();
	
	public ResponseEntity<List<Product>> viewAllProduct ();
	public Product viewProduct(int productId);
	public Product removeProduct(int productId) throws ProductException;
	public Product addProduct(Product product);

	public Product updateProduct(Product product) throws ProductException;

}
