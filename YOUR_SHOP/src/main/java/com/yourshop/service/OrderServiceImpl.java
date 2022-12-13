package com.yourshop.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourshop.dto.AddressDto;
import com.yourshop.dto.ProductDto;
import com.yourshop.exception.AddressException;
import com.yourshop.exception.CartException;
import com.yourshop.exception.LoginException;
import com.yourshop.exception.OrderException;
import com.yourshop.model.Address;
import com.yourshop.model.Cart;
import com.yourshop.model.CurrentCustomerSession;
import com.yourshop.model.Customer;
import com.yourshop.model.Orders;
import com.yourshop.repository.CartRepo;
import com.yourshop.repository.CustomerRepo;
import com.yourshop.repository.CustomerSessionRepo;
import com.yourshop.repository.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService{
	
	
	@Autowired
	private OrderRepo oRepo;
	
	@Autowired
	private CartRepo ctRepo;
	
	@Autowired
	CustomerRepo custRepo;
	
	
	@Autowired
	CustomerSessionRepo csessionRepo;

	@Override
	public Orders addOrder(Orders order,String loginkey) throws LoginException, CartException {
		// TODO Auto-generated method stub
		
		CurrentCustomerSession currentSession = csessionRepo.findByUuid(loginkey);
		
		Customer currentCustomer = custRepo.findById(currentSession.getCurrentUserId()).get();
		
		if(currentCustomer == null)
		{
			throw new LoginException("Please do login!");
		}
		
		Address addr = currentCustomer.getAddress();
		
		Orders newOrder = new Orders();
		newOrder.setOrderDate(LocalDate.now());
		newOrder.setOrderAddress(new AddressDto(addr.getStreetNo(), addr.getBuildingName(), addr.getCity(), addr.getState(), addr.getCountry(), addr.getPincode()));
		newOrder.setCustomer(currentCustomer);
		newOrder.setOrderStatus("Confirmed");
		
		
		List<ProductDto> products = ctRepo.findByCustomer(currentCustomer).getProducts();
		if( products.size() < 1) {
			 throw new CartException("Add product to the cart first...");
		 }
		
		List<ProductDto> productList = new ArrayList<>();
		
		Double total = 0.0;
		
		for(ProductDto prod : products)
		{
			productList.add(prod);
			total+= prod.getPrice() * prod.getQuantity();
		}
		
		newOrder.setTotal(total);
		newOrder.setPList(productList);
		
		Cart customerCart = ctRepo.findByCustomer(currentCustomer);
		customerCart.setProducts(new ArrayList<>());
		ctRepo.save(customerCart);
		
		Orders saveOrders = oRepo.save(newOrder);
		return saveOrders;
	}
	
	
	@Override
	public Orders updateOrders(Orders order, String loginkey) throws OrderException, LoginException {
		// TODO Auto-generated method stub
		CurrentCustomerSession currentSession = csessionRepo.findByUuid(loginkey);
		
		Customer currentCustomer = custRepo.findById(currentSession.getCurrentUserId()).get();
		
		if(currentCustomer == null)
		{
			throw new LoginException("Please do login!");
		}
		
		Optional<Orders> check = oRepo.findById(order.getOrderId());
		
		if(check.isPresent()) 
		{
			return oRepo.save(order);
		}
		else 
		{
			throw new OrderException("Order not exist by this id ");
		}
		
	}

	@Override
	public Orders removeOrders(Integer orderId, String loginkey) throws OrderException, LoginException {
		// TODO Auto-generated method stub
		
		CurrentCustomerSession currentSession = csessionRepo.findByUuid(loginkey);
		
		Customer currentCustomer = custRepo.findById(currentSession.getCurrentUserId()).get();
		
		if(currentCustomer == null)
		{
			throw new LoginException("Please do login!");
		}
		Orders check1 = oRepo.findById(orderId)
						   .orElseThrow(()->new OrderException("order not exist with given id.."));
		oRepo.delete(check1);
		return check1;
	}

	

//	@Override
//	public Orders viewOrders(Orders order) throws OrderException{
//		// TODO Auto-generated method stub
//		Optional<Orders> check2=oRepo.findById(order.getOrderId());
//		if(check2.isPresent()) {
//			return check2.get();
//		}else {
//			throw new OrderException("No order found by this id "+order.getOrderId());
//		}
//		
//	}
	@Override
	public Orders viewOrder(Integer orderId) throws OrderException {
		// TODO Auto-generated method stub
		Optional<Orders> opt1=  oRepo.findById(orderId);
		
		if(opt1.isPresent()) {
			return opt1.get();
		}
		else 
		{
			throw new OrderException("No order found");
		}
		
	}
	@Override
	public List<Orders> viewAllOrders(LocalDate date) throws OrderException {
		// TODO Auto-generated method stub
		List<Orders> allOrders= oRepo.findByOrderDate(date);
		if(allOrders.size()>0) {
			return allOrders;
		}
		else 
		{
			throw new OrderException("order not exist by given date :"+date);
		}
		
	}
	@Override
	public List<Orders> viewAllOrdersByLocation(String Location) throws OrderException,AddressException {
		// TODO Auto-generated method stub
		List<Orders> list=oRepo.getOrderByCity(Location);
		if(list.size()>0) 
		{
			return list;
		}
		else 
		{
			throw new OrderException("No order found with this userId.");
		}
		
	}
	@Override
	public List<Orders> viewAllOrdersByuserId(String mobileNumber) throws OrderException {
		// TODO Auto-generated method stub
		List<Orders> list2 = oRepo.getOrdersByUserId(mobileNumber);
		
		if( list2.size() < 1) 
		{
			throw new OrderException("No order found with this userId.");
		}
		
		return list2;
		
	}
	



	

}