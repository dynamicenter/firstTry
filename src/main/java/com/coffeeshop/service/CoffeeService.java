package com.coffeeshop.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffeeshop.components.entity.Coffee;
import com.coffeeshop.components.interface_i.ICoffee;

@Service
public class CoffeeService {
	@Autowired
	private ICoffee iCoffee;
	
	public Coffee searchByIdCoffee(int id) {
		return iCoffee.searchByIdCoffee(id);
	}
	
	public void addCoffee(Coffee coffee) {
		iCoffee.addCoffee(coffee);	
	}
	
	public Collection<Coffee>infoAboutCoffee(int page){
		return iCoffee.infoAboutCoffee(page);
	}
	
	
}
