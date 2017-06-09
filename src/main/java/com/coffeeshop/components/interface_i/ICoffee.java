package com.coffeeshop.components.interface_i;

import java.util.Collection;

import com.coffeeshop.components.entity.Coffee;

public interface ICoffee {
	
	public Coffee searchByIdCoffee(int id);
	
	public Collection<Coffee> infoAboutCoffee(int page);
	
	public void addCoffee(Coffee coffee);
	
	
	
}