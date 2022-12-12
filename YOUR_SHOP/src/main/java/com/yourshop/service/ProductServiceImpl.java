package com.yourshop.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.yourshop.exception.CategoryException;
import com.yourshop.exception.ProductException;
import com.yourshop.model.Category;
import com.yourshop.model.CurrentAdminSession;
import com.yourshop.model.Product;
import com.yourshop.repository.AdminSessionRepo;
//import com.yourshop.repository.CategoryRepo;
import com.yourshop.repository.ProductRepo;


@Service
public class ProductServiceImpl implements ProductService{
	
	
	@Autowired
	private ProductRepo pr;
	
//	@Autowired
//	private CategoryRepo catRepo;
	
	@Autowired
	private AdminSessionRepo adRepo;


	@Override
	public List<Product> viewAllProducts() {
		List<Product> list=pr.findAll();
		if(list.size()==0) {
//		throw ExceptionInInitializerError;
		}
		
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public ResponseEntity<List<Product>> viewAllProduct() {
		// TODO Auto-generated method stub
		
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
	Product	pr2 =pr.save(product);
		return pr2;
	}

	public Product removeProduct(int productId) throws ProductException {
		// TODO Auto-generated method stub
		Optional<Product> productOpt = pr.findById(productId);
		if(productOpt.isPresent())
		{
			Product product = productOpt.get();
			pr.deleteById(productId);
			return product;
		}
		else
		{
			throw new ProductException("Product is not available with product id: "+productId);
		}
		
		
		
	}

	public Product viewProduct(int productId) {
		// TODO Auto-generated method stub
	Optional<Product> pr3 = 	pr.findById(productId);
		return pr3.get();
	}


	@Override
	public Product updateProduct(Product product) throws ProductException {
		
		
		Optional<Product> opt= pr.findById(product.getProductId());
		if(opt.isPresent()) {
			Product updated = pr.save(product);
			return updated;
		}
		else 
			throw new ProductException("Invalid Product Details Please Check");
		
	}


}
