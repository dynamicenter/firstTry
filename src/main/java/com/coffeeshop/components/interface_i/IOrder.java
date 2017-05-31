package com.coffeeshop.components.interface_i;

import java.util.Collection;

import com.coffeeshop.components.entity.Order;


public interface IOrder {
	
	public Collection<Order> infoAboutOrder(Long id);

	public Order searchByIdOrder(Long id);
	
	public void updateOrder(Order order);

	public void deleteOrder(Long id);
	
	public void deleteItem(Long id);
	
	public void createOrder(Order order);

}
