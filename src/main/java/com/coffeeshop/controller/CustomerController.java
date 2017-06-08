package com.coffeeshop.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coffeeshop.components.entity.Customer;
import com.coffeeshop.service.CustomerService;

@RestController
@RequestMapping("/shop/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	/**
	 * Get customers by id from DB
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public Customer searchByIdCustomer(@PathVariable("id") int id) {
		return customerService.searchByIdCustomer(id);
	}

	/**
	 * Get all customers from DB
	 * 
	 * @return
	 */
	@RequestMapping(value = "/information/{page}", method = RequestMethod.GET)
	public Collection<Customer> searchCustomers(@PathVariable("page") int page) {
		return customerService.searchCustomers(page);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
		return "SUCCESS: Customer was created!";
	}
}