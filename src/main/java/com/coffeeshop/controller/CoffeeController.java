package com.coffeeshop.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coffeeshop.components.entity.Coffee;
import com.coffeeshop.service.CoffeeService;

@RestController
@RequestMapping("/shop/coffee")
public class CoffeeController {
	@Autowired
	private CoffeeService coffeeService;

	/**
	 * Get products by id from DB
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public Coffee searchByIdCoffee(@PathVariable("id") int id) {
		return coffeeService.searchByIdCoffee(id);
	}

	/**
	 * Get all products from DB
	 * 
	 * @return
	 */
	@RequestMapping(value = "/information/{page}", method = RequestMethod.GET)
	public Collection<Coffee> infoAboutCoffee(@PathVariable("page") int page) {
		return coffeeService.infoAboutCoffee(page);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String addCoffee(@RequestBody Coffee coffee) {
		coffeeService.addCoffee(coffee);
		return "SUCCESS: Coffee was created!";
	}
}
