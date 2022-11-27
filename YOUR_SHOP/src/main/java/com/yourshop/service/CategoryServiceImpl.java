package com.yourshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourshop.exception.CategoryException;
import com.yourshop.model.Category;
import com.yourshop.model.Product;
import com.yourshop.repository.CategoryRepo;


@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepo cRepo;

	@Override
	public Category createCategory(Category category) throws CategoryException {
		// TODO Auto-generated method stub
		return cRepo.save(category);
	}

	@Override
	public Category viewCategory(int categoryId) throws CategoryException {
		// TODO Auto-generated method stub
		Optional<Category> category =cRepo.findById(categoryId);
		
		if(category.isPresent()) 
		{
			return category.get();
		}
		else
		{
			throw new CategoryException("category not found");
		}
		
	}

	@Override
	public Category removeCategory(int categoryId) throws CategoryException {
		// TODO Auto-generated method stub
		Optional<Category> catOpt =cRepo.findById(categoryId);
		
		if(catOpt.isPresent()) 
		{
			Category category = catOpt.get();
			cRepo.delete(category);
			return category;
		}
		else
		{
			throw new CategoryException("category not found");
		}
	}

	@Override
	public List<Category> allCategories() throws CategoryException {
		// TODO Auto-generated method stub
		List<Category> categories = cRepo.findAll();
		
		if(categories.size() == 0)
		{
			throw new CategoryException("Category list is empty");
		}
		else
		{
			return categories;
		}
	}

	@Override
	public List<Product> productsByCategory(int categoryId) throws CategoryException {
		Optional<Category> catOpt = cRepo.findById(categoryId);
		
		if(catOpt.isPresent())
		{
			return catOpt.get().getProduct();
		}
		else
		{
			throw new CategoryException("Category not found with this id");
		}
	}

}
