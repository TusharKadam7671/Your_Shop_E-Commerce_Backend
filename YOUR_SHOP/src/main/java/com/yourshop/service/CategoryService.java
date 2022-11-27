package com.yourshop.service;

import java.util.List;

import com.yourshop.exception.CategoryException;
import com.yourshop.model.Category;
import com.yourshop.model.Product;

public interface CategoryService {
	
	public Category createCategory(Category category)throws CategoryException;
	
	public Category viewCategory(int categoryId)throws CategoryException;
	
	public Category removeCategory(int categoryId)throws CategoryException;
	
	public List<Category> allCategories()throws CategoryException;
	
	public List<Product> productsByCategory(int categoryId)throws CategoryException;

}
