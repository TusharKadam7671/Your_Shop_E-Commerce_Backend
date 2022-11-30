package com.yourshop.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourshop.dto.ProductDTO;
import com.yourshop.exception.CartException;
import com.yourshop.exception.LoginException;
import com.yourshop.exception.ProductException;
import com.yourshop.model.Cart;
import com.yourshop.model.CurrentCustomerSession;
import com.yourshop.model.Customer;
import com.yourshop.model.Product;
import com.yourshop.repository.CartRepo;
import com.yourshop.repository.CustomerRepo;
import com.yourshop.repository.CustomerSessionRepo;
import com.yourshop.repository.ProductRepo;


@Service
public class CartServiceImpl implements CartService{
	
	
	@Autowired
	private CartRepo cartRepo;
	
	@Autowired
	private CustomerRepo cRepo;
	
	@Autowired
	private CustomerSessionRepo csRepo;
	
	@Autowired
	private ProductRepo pRepo;
	
	

	@Override
	public Cart addProductToCart(Integer productId, int quantity, String key)
			throws CartException, LoginException, ProductException {


		CurrentCustomerSession cCustSession =  csRepo.findByUuid(key);
		
		if(cCustSession != null)
		{
			Optional<Customer> custOpt = cRepo.findById(cCustSession.getCurrentUserId());
			
			if(custOpt.isPresent())
			{
				Customer currentCustomer = custOpt.get();
				
				
				Product product;
				
				if(pRepo.findById(productId).isPresent())
				{
					product = pRepo.findById(productId).get();
				}
				else
				{
					throw new ProductException("Product is not available with id: "+productId);
				}

				if(product.getQuantity() < quantity)
				{
					throw new ProductException("Out of stock");
				}
				
				Cart cart = cartRepo.findByCustomer(currentCustomer);
				
				if(cart == null)
				{
					cart = new Cart();
					cart.setCustomer(currentCustomer);
					
					/*
					List<ProductDTO> list = cart.getProducts();
					
					
					ProductDTO productdto = new ProductDTO(product.getProductId(), 
							product.getProductName(), 
							product.getPrice(), 
							product.getColor(), 
							product.getDimension(), 
							product.getManufacturer(), 
							quantity,
							product.getCategory()
							);
					
					product.setQuantity(product.getQuantity() - quantity);
					list.add(productdto);
					cart.setProducts(list);
					
					cartRepo.save(cart);
					pRepo.save(product);
					
					return cart;
					*/
					
					List<Product> list = cart.getProducts();
					
//					Product newp = new Product(product.getProductName(), product.getPrice(), product.getColor(), product.getDimension(), product.getManufacturer(), quantity, product.getCategory());
					
					Product newp = product;
					newp.setQuantity(quantity);
					product.setQuantity(product.getQuantity()-quantity);
					
					
					list.add(newp);
					cart.setProducts(list);
					cartRepo.save(cart);
					pRepo.save(product);
					return cart;
					
				}
				else
				{
					
					/*
					List<ProductDTO> list = cart.getProducts();
					
					
					ProductDTO productdto = new ProductDTO( product.getProductId(),
															product.getProductName(),
															product.getPrice(), 
															product.getColor(), 
															product.getDimension(),
															product.getManufacturer(),
															quantity,
															product.getCategory()
															);
					
					product.setQuantity(product.getQuantity() - quantity);
					
					list.add(productdto);
					cart.setProducts(list);
					
					cartRepo.save(cart) ;
					pRepo.save(product);
					 
					return cart;
					*/
					
					List<Product> list = cart.getProducts();
					
//					Product newp = new Product(product.getProductName(), product.getPrice(), product.getColor(), product.getDimension(), product.getManufacturer(), quantity, product.getCategory());
					
					Product newp = product;
					newp.setQuantity(quantity);
					product.setQuantity(product.getQuantity()-quantity);
					
					
					list.add(newp);
					cart.setProducts(list);
					cartRepo.save(cart);
					pRepo.save(product);
					return cart;
				}
				
				
				
			}
			else
			{
				throw new LoginException("Please login to continue");
			}
			
			
		}
		else
		{
			throw new LoginException("Please login to continue");
		}
		
	}

	
	@Override
	public Cart removeProductFromCart(Integer productId, String key)
			throws CartException, ProductException, LoginException {


		CurrentCustomerSession currentSession = csRepo.findByUuid(key);
		
		if(currentSession != null)
		{
			
			Optional<Customer> custOpt = cRepo.findById(currentSession.getCurrentUserId());
			
			if(custOpt.isPresent())
			{
		
				Customer currentCustomer = custOpt.get();
		
	

		Product product;
		
		if(pRepo.findById(productId).isPresent())
		{
			product = pRepo.findById(productId).get();
		}
		else
		{
			throw new ProductException("Product is not available with id: "+productId);
		}

		
		Cart cart = cartRepo.findByCustomer(currentCustomer);
		
		if(cart != null)
		{
//			List<ProductDTO> list = cart.getProducts();
			List<Product> list = cart.getProducts();
			boolean flag = false;
			
			for(int i = 0; i < list.size(); i++) {
				
//				ProductDTO oldproduct = list.get(i) ;
				Product oldproduct = list.get(i) ;
				
				if(oldproduct.getProductId() == productId) {
					
					
					
					pRepo.deleteById(oldproduct.getProductId());
					
					flag = true;
					
					product.setQuantity(product.getQuantity() + oldproduct.getQuantity());
					pRepo.save(product);
					
					list.remove(i) ;
					break;
				}
				
			}
			
			if(!flag)
			{
				throw new ProductException("Product is not available with product id: "+productId);
			}
			
			cart.setProducts(list);
			cartRepo.save(cart);
			
			return cart;
			
		}
		else
		{
			throw new CartException("The cart is empty");
		}
		
			}
			else
			{
				throw new LoginException("Please login to continue");
			}
		
		}
		else
		{
			throw new LoginException("Please login to continue");
		}
	}

	@Override
	public Cart increaseProductQuantity(Integer productId, Integer quantity, String key)
			throws CartException, LoginException, ProductException {

		CurrentCustomerSession currentSession = csRepo.findByUuid(key);
		
		if(currentSession != null)
		{
			
			Optional<Customer> custOpt = cRepo.findById(currentSession.getCurrentUserId());
			
			if(custOpt.isPresent())
			{
		
				Customer currentCustomer = custOpt.get();
				
				Product product;
				
				if(pRepo.findById(productId).isPresent())
				{
					product = pRepo.findById(productId).get();
				}
				else
				{
					throw new ProductException("Product is not available with id: "+productId);
				}
				
				Cart cart = cartRepo.findByCustomer(currentCustomer);
				
				if(cart == null)
				{
					throw new CartException("Cart is empty");
				}
				
				cart.getProducts().forEach(
						p->{
							if(p.getProductId()==productId)
							{
								p.setQuantity(p.getQuantity()+quantity);
							}
						}
						);
				
				return cartRepo.save(cart);
			}
			else
			{
				throw new LoginException("Please login to continue");
			}
		
		}
		else
		{
			throw new LoginException("Please login to continue");
		}
		
	}

	@Override
	public Cart decreaseProductQuantity(Integer productId, Integer quantity, String key)
			throws CartException, LoginException, ProductException {
		// TODO Auto-generated method stub


	CurrentCustomerSession currentSession = csRepo.findByUuid(key);
		
		if(currentSession != null)
		{
			
			Optional<Customer> custOpt = cRepo.findById(currentSession.getCurrentUserId());
			
			if(custOpt.isPresent())
			{
		
				Customer currentCustomer = custOpt.get();
				
				Product product;
				
				if(pRepo.findById(productId).isPresent())
				{
					product = pRepo.findById(productId).get();
				}
				else
				{
					throw new ProductException("Product is not available with id: "+productId);
				}
				
				Cart cart = cartRepo.findByCustomer(currentCustomer);
				
				if(cart == null)
				{
					throw new CartException("Cart is empty");
				}
				
				cart.getProducts().forEach(
						p->{
							if(p.getProductId()==productId)
							{
								p.setQuantity(p.getQuantity() - quantity);
								if(p.getQuantity() < 0)
								{
									p.setQuantity(0);
								}
							}
						}
						);
				
				return cartRepo.save(cart);
				
			}
			else
			{
				throw new LoginException("Please login to continue");
			}
		
		}
		else
		{
			throw new LoginException("Please login to continue");
		}
	}

	@Override
	public Cart viewAllProducts(String key) throws CartException, LoginException {
		// TODO Auto-generated method stub

	CurrentCustomerSession currentSession = csRepo.findByUuid(key);
		
		if(currentSession != null)
		{
			
			Optional<Customer> custOpt = cRepo.findById(currentSession.getCurrentUserId());
			
			if(custOpt.isPresent())
			{
		
				Customer currentCustomer = custOpt.get();
				
				Cart cart = cartRepo.findByCustomer(currentCustomer);
				
				if(cart == null)
				{
					throw new CartException("Cart is empty");
				}
				
				return cart;
				
			}
			else
			{
				throw new LoginException("Please login to continue");
			}
		
		}
		else
		{
			throw new LoginException("Please login to continue");
		}
	}

	@Override
	public Cart removeAllProducts(String key) throws CartException, LoginException {
		// TODO Auto-generated method stub


	CurrentCustomerSession currentSession = csRepo.findByUuid(key);
		
		if(currentSession != null)
		{
			
			Optional<Customer> custOpt = cRepo.findById(currentSession.getCurrentUserId());
			
			if(custOpt.isPresent())
			{
		
				Customer currentCustomer = custOpt.get();
				
				Cart cart = cartRepo.findByCustomer(currentCustomer);
				
				if(cart == null)
				{
					throw new CartException("Cart is empty");
				}
				
//				List<ProductDTO> products = cart.getProducts();
				List<Product> products = cart.getProducts();
				products.forEach(p-> {
					
					Optional<Product> pOpt = pRepo.findById(p.getProductId());
					
					
					if(pOpt.isPresent())
					{
						Product fromProduct = pOpt.get();
						fromProduct.setQuantity(fromProduct.getQuantity() + p.getQuantity() );
						pRepo.save(fromProduct);
					}
					else
					{	
						/*
						Product prod = new Product(p.getProductName() , p.getPrice(), p.getColor(), p.getDimension(), p.getManufacturer(), p.getQuantity(),"NA");
						pRepo.save(prod);
						*/
					}
					
					
					
				});
				
				cart.setProducts(new ArrayList<>());
				return cartRepo.save(cart);
				
				
			}
			else
			{
				throw new LoginException("Please login to continue");
			}
		
		}
		else
		{
			throw new LoginException("Please login to continue");
		}
	}

}
