//package com.yourshop.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.yourshop.exception.CategoryException;
//import com.yourshop.model.Category;
//import com.yourshop.model.Product;
//import com.yourshop.service.CategoryService;
//
//@RestController
//@RequestMapping("/category")
//public class CategoryController {
//	
//	@Autowired
//	private CategoryService catService;
//	
//	@PostMapping("/add")
//	public ResponseEntity<Category> addCategory(@RequestBody Category category) throws CategoryException 
//	{
//		Category savedCategory =catService.createCategory(category);
//		
//		return new ResponseEntity<Category>(savedCategory,HttpStatus.CREATED);
//	}
//	
//	@GetMapping("/view/{id}")
//	public ResponseEntity<Category> viewCategory(@PathVariable("id") int categoryId) throws CategoryException 
//	{
//		Category category = catService.viewCategory(categoryId);
//		
//		return new ResponseEntity<Category>(category,HttpStatus.OK);
//		
//	}
//	
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<Category> deleteCategory(@PathVariable("id") int categoryId) throws CategoryException 
//	{
//		Category category = catService.removeCategory(categoryId);
//		
//		return new ResponseEntity<Category>(category,HttpStatus.ACCEPTED);
//	}
//	
//	@GetMapping("/viewAll")
//	public ResponseEntity<List<Category>> allCategory() throws CategoryException 
//	{
//		List<Category> categories = catService.allCategories();
//		
//		return new ResponseEntity<List<Category>>(categories,HttpStatus.OK);
//	}
//	
//	/*
//	@GetMapping("/viewProductByCategory/{id}")
//	public ResponseEntity<List<Product>> productByCategory(@PathVariable("id") int categoryId) throws CategoryException 
//	{
//		List<Product> products = catService.productsByCategory(categoryId);
//		
//		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
//	}
//*/
//
//}
