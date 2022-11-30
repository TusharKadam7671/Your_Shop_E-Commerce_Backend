package com.yourshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yourshop.exception.CartException;
import com.yourshop.exception.LoginException;
import com.yourshop.exception.ProductException;
import com.yourshop.model.Cart;
import com.yourshop.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/add")
	public ResponseEntity<Cart> addToCartHandler(@RequestParam Integer productId,
			@RequestParam Integer quantity,
			@RequestParam String key) throws CartException, LoginException, ProductException
	{
		Cart added = cartService.addProductToCart(productId, quantity, key);
		
		return new ResponseEntity<Cart>(added, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/removeone")
	public ResponseEntity<Cart> removeProductFromCartHandler(@RequestParam Integer productId, @RequestParam String key) throws CartException, ProductException, LoginException
	{
		Cart removed = cartService.removeProductFromCart(productId, key);
		
		return new ResponseEntity<Cart>(removed, HttpStatus.CREATED);
	}

	@PutMapping("/add")
	public ResponseEntity<Cart> increaseQuantHandler(@RequestParam Integer productId,
			@RequestParam Integer quantity,
			@RequestParam String key ) throws CartException, LoginException, ProductException
	{
		Cart increase = cartService.increaseProductQuantity(productId, quantity, key);
		
		return new ResponseEntity<Cart>(increase, HttpStatus.ACCEPTED);
	}
	
	
	@PutMapping("/remove")
	public ResponseEntity<Cart> decreaseQuantHandler(@RequestParam Integer productId,
			@RequestParam Integer quantity,
			@RequestParam String key ) throws CartException, LoginException, ProductException
	{
		Cart decrease = cartService.decreaseProductQuantity(productId, quantity, key);
		
		return new ResponseEntity<Cart>(decrease, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Cart> viewAllFromCartHandler(@RequestParam String key) throws CartException, LoginException
	{
		Cart cart = cartService.viewAllProducts(key);
		
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}
	
	@DeleteMapping("/removeall")
	public ResponseEntity<Cart> removeAllProductsHandler(@RequestParam String key) throws CartException, LoginException
	{
		Cart cart = cartService.removeAllProducts(key);
		
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}
}
