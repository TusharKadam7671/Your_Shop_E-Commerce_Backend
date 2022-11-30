package com.yourshop.service;

import com.yourshop.exception.CartException;
import com.yourshop.exception.LoginException;
import com.yourshop.exception.ProductException;
import com.yourshop.model.Cart;

public interface CartService {
	
	public Cart addProductToCart(Integer productId, int quantity,String key) throws CartException, LoginException, ProductException ;
	
	public Cart removeProductFromCart(Integer productId,String key) throws CartException, ProductException, LoginException  ;
	
	public Cart increaseProductQuantity(Integer productId,Integer quantity,String key) throws CartException, LoginException, ProductException ;
	
	public Cart decreaseProductQuantity(Integer productId,Integer quantity,String key) throws CartException, LoginException, ProductException ;
	
	public Cart viewAllProducts(String key)  throws CartException, LoginException;
	
	public Cart removeAllProducts(String key) throws CartException, LoginException ;
	
	

}
