package com.coffeeshop.components.interface_i;

import java.util.Collection;

import com.coffeeshop.components.entity.Customer;

public interface ICustomer {
	
	public Customer searchByIdCustomer(int id);
	
	public Collection<Customer> searchCustomers(int page);
	
	public void addCustomer(Customer customer);
	
	
	
	
}
