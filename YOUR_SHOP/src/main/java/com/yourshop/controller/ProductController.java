package com.yourshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yourshop.exception.CategoryException;
import com.yourshop.exception.ProductException;
import com.yourshop.model.Product;
import com.yourshop.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService pService;
	
	@PostMapping("/add/{categoryId}")
	public ResponseEntity<Product> addProduct(@RequestBody Product product, @PathVariable("categoryId") int categoryId) throws ProductException, CategoryException 
	{
		Product addedProduct = pService.addProduct(product, categoryId);
		return new ResponseEntity<Product>(addedProduct,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) throws ProductException 
	{
		Product updated = pService.updateProduct(product);
		return new ResponseEntity<Product>(updated,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/view/{productId}")
	public ResponseEntity<Product> viewProduct(@PathVariable("productId") int productId) throws ProductException 
	{
		Product product = pService.viewProduct(productId);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	@GetMapping("/productByName/{name}")
	public ResponseEntity<List<Product>> productByName(@PathVariable("name") String name) throws ProductException 
	{
		List<Product> products = pService.productByName(name);
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	@GetMapping("/viewAllProduct")
	public ResponseEntity<List<Product>> allProduct() throws ProductException 
	{
		List<Product> products = pService.viewAllProducts();
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{productId}/{key}")
	public ResponseEntity<Product> removeProduct(@PathVariable("productId") int productId, @PathVariable("key") String key) throws ProductException 
	{
		Product deleted = pService.removeProduct(productId, key);
		return new ResponseEntity<Product>(deleted,HttpStatus.ACCEPTED);
	}
	
	
	
	

}
