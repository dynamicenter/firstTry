package com.coffeeshop.service;



import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffeeshop.components.entity.Order;
import com.coffeeshop.components.interface_i.IOrder;


@Service
public class OrderService {
	
	@Autowired
	public IOrder iOrder;
	
	public Order searchByIdOrder(Long id){
		return iOrder.searchByIdOrder(id);
	}
	public Collection<Order>infoAboutOrder(Long id){
		return iOrder.infoAboutOrder(id);
	}
	
	public void deleteItem(Long id){	
		
		iOrder.deleteItem(id);
	}
	
	public void deleteOrder(Long id){
		iOrder.deleteOrder(id);
	}
	
	public void createOrder(Order order){
		iOrder.createOrder(order);
	}
	
	public void updateOrder(Order order){
		iOrder.updateOrder(order);
	} 
	
	
	
	
}
