package com.yourshop.service;

import java.util.List;

import com.yourshop.dto.ProductDto;
import com.yourshop.exception.CartException;
import com.yourshop.exception.LoginException;
import com.yourshop.exception.ProductException;
import com.yourshop.model.Cart;

public interface CartService {
	
public Cart addProductToCart(Integer productId, int quantity,String key) throws CartException, LoginException, ProductException ;
	
//	public List<ProductDto> removeProductFromCart(Integer productId,String key) throws CartException, ProductException, LoginException  ;
	
	public Cart removeProductFromCart(Integer productId,String key) throws CartException, ProductException, LoginException  ;
	
	public List<ProductDto> updateProductQuantity(Integer productId,Integer quantity,String key) throws CartException, LoginException, ProductException ;
	
	public Cart removeAllProducts(String key) throws CartException, LoginException ;
	
	public List<ProductDto> viewAllProducts(String key)  throws CartException, LoginException;
	
	

}
