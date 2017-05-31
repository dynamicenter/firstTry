package com.coffeeshop.components.interface_i;

import java.util.Collection;

import com.coffeeshop.components.entity.Customer;

public interface ICustomer {
	
	public Customer searchByIdCustomer(Long id);
	
	public Collection<Customer> infoAboutCustomers();
	
	public void addCustomer(Customer customer);
	
	
	
	
}
