package com.coffeeshop.components.interface_i;

import java.util.Collection;

import com.coffeeshop.components.entity.Coffee;

public interface ICoffee {
	
	public Coffee searchByIdCoffee(Long id);
	
	public Collection<Coffee> infoAboutCoffee();
	
	public void addCoffee(Coffee coffee);
	
	
	
}