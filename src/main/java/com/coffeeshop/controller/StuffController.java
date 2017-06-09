package com.coffeeshop.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coffeeshop.components.entity.Stuff;
import com.coffeeshop.service.StuffService;

@RestController
@RequestMapping("/shop/stuff")
public class StuffController {
	@Autowired
	private StuffService stuffService;

	/**
	 * Get workers by id from DB
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public Stuff searchByIdStuff(@PathVariable("id") int id) {
		return stuffService.searchByIdStuff(id);
	}

	/**
	 * Get all workers from DB
	 * 
	 * @return
	 */
	@RequestMapping(value = "/information/{page}", method = RequestMethod.GET)
	public Collection<Stuff> infoAboutStuff(@PathVariable("page") int page) {
		return stuffService.infoAboutStuff(page);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String addStuff(@RequestBody Stuff stuff) {
		stuffService.addStuff(stuff);
		return "SUCCESS: Stuff was created!";
	}
}