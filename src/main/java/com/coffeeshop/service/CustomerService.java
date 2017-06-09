package com.coffeeshop.service;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffeeshop.components.entity.Customer;
import com.coffeeshop.components.interface_i.ICustomer;

@Service
public class CustomerService {
	@Autowired
	public ICustomer iCustomer;
	
	public Customer searchByIdCustomer(int id){
		return iCustomer.searchByIdCustomer(id);
	}
	
	public Collection<Customer> searchCustomers(int page) {
		return iCustomer.searchCustomers(page);
	}
	
	
	public void addCustomer(Customer customer){
		iCustomer.addCustomer(customer);
	}
	
}
