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
	private ProductService productService;
	
	

		
		@GetMapping("/viewallproduct")
		public List<Product> getAllProduct(){
			return productService.viewAllProducts();
		}


	    @PostMapping("/addproduct")
	    public ResponseEntity<Product> addProduct(@RequestBody Product product){
	        Product product2 = productService.addProduct(product);
	        return new ResponseEntity<Product>(product2, HttpStatus.OK); 
	        		}

	    @DeleteMapping("/deleteproduct/{productId}")
	    public ResponseEntity<Product> removeProduct(@PathVariable int productId) throws ProductException {
	        Product product = productService.removeProduct(productId);
	        return new ResponseEntity<Product>(product,HttpStatus.OK);
	    }

	    @GetMapping("/viewproductbyid/{productId}")
	    public Product viewProduct(@PathVariable int productId) throws ProductException {
	        return productService.viewProduct(productId);
	    }

	    
		@PutMapping ("/product")
		public ResponseEntity<Product> updateProductHandler(@RequestBody Product product) throws ProductException{
			
			Product update= productService.updateProduct(product);
			
			return new ResponseEntity<Product>(update,HttpStatus.ACCEPTED);
			
			
		}


	
	

}
