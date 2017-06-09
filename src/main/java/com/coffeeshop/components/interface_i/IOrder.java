package com.coffeeshop.components.interface_i;

import java.util.Collection;

import com.coffeeshop.components.entity.Order;


public interface IOrder {
	
	public Collection<Order> infoAboutOrder(int page);

	public Order searchByIdOrder(int id);
	
	public void createOrder(Order order);

}
