package com.coffeeshop.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coffeeshop.components.entity.Stuff;
import com.coffeeshop.components.interface_i.IStuff;

@Service
public class StuffService {
	
	@Autowired
	private IStuff iStuff;

	public Stuff searchByIdStuff(int id) {
		return iStuff.searchByIdStuff(id);
	}

	public Collection<Stuff> infoAboutStuff(int page) {
		return iStuff.infoAboutStuff(page);
	}

	public void addStuff(Stuff stuff) {
		iStuff.addStuff(stuff);
	}
}
