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
	
	public Order searchByIdOrder(int id){
		return iOrder.searchByIdOrder(id);
	}
	public Collection<Order>infoAboutOrder(int page){
		return iOrder.infoAboutOrder(page);
	}
	
	public void createOrder(Order order){
		iOrder.createOrder(order);
	}

	
	
	
	
}
