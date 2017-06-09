package com.coffeeshop.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coffeeshop.components.entity.Order;
import com.coffeeshop.service.OrderService;

@RestController
@RequestMapping("/shop/order")
public class OrderController {
	@Autowired
	private OrderService orderService;

	/**
	 * Get all orders from DB
	 * 
	 * @return
	 */
	@RequestMapping(value = "/{page}", method = RequestMethod.GET)
	public Collection<Order> infoAboutAllOrder(@PathVariable("page") int page) {
		return orderService.infoAboutOrder(page);
	}

	/**
	 * Get totalsum orders from DB
	 * 
	 * @return
	 */
	@RequestMapping(value = "/view_order/{id}", method = RequestMethod.GET)
	public Order searchByIdOrder(@PathVariable("id") int id) {
		return orderService.searchByIdOrder(id);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createOrder(@RequestBody Order order) {
		orderService.createOrder(order);
		return "SUCCESS: Order was created!";
	}
}