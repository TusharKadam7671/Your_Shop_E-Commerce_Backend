package com.yourshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourshop.exception.CategoryException;
import com.yourshop.exception.ProductException;
import com.yourshop.model.Category;
import com.yourshop.model.CurrentAdminSession;
import com.yourshop.model.Product;
import com.yourshop.repository.AdminSessionRepo;
import com.yourshop.repository.CategoryRepo;
import com.yourshop.repository.ProductRepo;


@Service
public class ProductServiceImpl implements ProductService{
	
	
	@Autowired
	private ProductRepo pRepo;
	
	@Autowired
	private CategoryRepo catRepo;
	
	@Autowired
	private AdminSessionRepo adRepo;

	@Override
	public Product addProduct(Product product, int categoryId) throws ProductException, CategoryException {


		Optional<Category> catOpt = catRepo.findById(categoryId);
		
		if(catOpt.isPresent())
		{
			Category category = catOpt.get();
			
			category.getProduct().add(product);
			
			product.setCategory(category);
			
			catRepo.save(category);
			
			return product;
		}
		else
		{
			throw new CategoryException("Category not found with given id");
		}
	}

	@Override
	public Product updateProduct(Product product) throws ProductException {
			
		Optional<Product> pOpt = pRepo.findById(product.getProductId());
		
		if(pOpt.isPresent())
		{
			Product oldProduct = pOpt.get();
			
			oldProduct.setPrice(product.getPrice());
			oldProduct.setProductName(product.getProductName());
			oldProduct.setQuantity(product.getQuantity());
			
			
			return pRepo.save(oldProduct);
		}
		else
		{
			throw new ProductException("Product is not found with given id");
		}
	}

	@Override
	public Product viewProduct(int productId) throws ProductException {
		// TODO Auto-generated method stub
		Optional<Product> productOpt = pRepo.findById(productId);
		
		if(productOpt.isPresent())
		{
			return productOpt.get();
		}
		else
		{
			throw new ProductException("Product is not found with given product id");
		}
	}

	@Override
	public List<Product> productByName(String name) throws ProductException {


		List<Product> products = pRepo.findByProductName(name);
		
		if(products.size() != 0)
		{
			return products;
		}
		else
		{
			throw new ProductException("Product is not found with given name");
		}
	}

	@Override
	public List<Product> viewAllProducts() throws ProductException {
		// TODO Auto-generated method stub

		List<Product> products = pRepo.findAll();
		
		if(products.size() != 0)
		{
			return products;
		}
		else
		{
			throw new ProductException("Product list is empty");
		}
	}

	@Override
	public Product removeProduct(int productId, String key) throws ProductException {
		// TODO Auto-generated method stub
		
		CurrentAdminSession session = adRepo.findByUuid(key);
		
		if(session == null )
		{
			throw new ProductException("Please login as admin");
		}
		
		Optional<Product> pOpt = pRepo.findById(productId);
		
		if(pOpt.isPresent())
		{
			pRepo.delete(pOpt.get());
			return pOpt.get();
		}
		else
		{
			throw new ProductException("Product not found with given id");
		}
		
	}

}
