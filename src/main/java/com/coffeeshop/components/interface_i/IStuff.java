package com.coffeeshop.components.interface_i;

import java.util.Collection;

import com.coffeeshop.components.entity.Stuff;

public interface IStuff {
	
	public Stuff searchByIdStuff(int id);

	Collection<Stuff> infoAboutStuff(int page);

	public void addStuff(Stuff worker);

}
